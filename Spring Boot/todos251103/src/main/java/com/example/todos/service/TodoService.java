package com.example.todos.service;

import com.example.todos.dto.TodoDto;
import com.example.todos.entity.Todo;
import com.example.todos.entity.YnFlag;
import com.example.todos.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true) //조회 전용. 전체 클래스의 조회 전용을 감지
@RequiredArgsConstructor //필드값의 의존성 주입이 자동으로 될 수 있게
public class TodoService {

    private final TodoRepository repo; //DB에 직접 연결된 리포지토리
    private final FileImageService fileImageService;

    //등록
    @Transactional
    public Todo register(TodoDto dto) {
        //Todo todo = Todo.builder().content(content).build();
        // Todo todo = dto.toEntity(); / id(this.id), regDate(this.regDate)를 그대로 넣기 때문에 의도하지 않는 업데이트가 있을 수 있음
        Todo todo = Todo.builder()
                .content(dto.getContent())
                .isCompleted(dto.getIsCompleted() != null ? dto.getIsCompleted() : YnFlag.N)
                .build();
        return repo.save(todo);
    }

    //전체 조회
    public List<Todo> findAll() {
        return repo.findAll();
    }

    //개별조회
    public Todo findById(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "번호 잘못 입력"));
        // return repo.findById(id); 로만 처리하면 에러가 뜸
    }

    //삭제
    @Transactional // 삭제는 읽기만 하는 게 아니기 때문에, Transactional(readOnly=true) 말고 기본 Transactional 이 필요함
    public void delete(int id) {//오류가 있는지 없는지 먼저 확인을 하고 지워줘야 함
        Todo todo = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "번호 잘못 입력"));
        repo.deleteById(id);

        // (사진) 파일 삭제
        fileImageService.deleteImage(todo.getImageUrl());
    }

    //전체 수정
    @Transactional
    public Todo updateContent(int id, TodoDto dto){
        Todo todo = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "번호 잘못 입력"));

        if(dto.getContent() == null || dto.getContent().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "할 일은 필수입니다.");
        }
        todo.updateContent(dto.getContent());
        todo.updateDone(dto.getIsCompleted() != null ? dto.getIsCompleted() : YnFlag.N);
        todo.updateImageUrl(dto.getImageUrl());
        return todo;
    }
    //Y,N 수정만
    @Transactional
    public Todo updateYn(int id, YnFlag flag) {
        Todo todo = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "번호 잘못 입력"));
        todo.updateDone(flag);
        return todo;
    }

    // 이미지 포함 등록
    @Transactional
    public TodoDto registerImage(String content, YnFlag isCompleted, MultipartFile image){
        //필수 값 설정
        if(content == null || content.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "할 일은 필수입니다.");
        }

        // 파일 저장
        // !image.isEmpty();  ! 부정연산자
        String imageUrl = (image != null && !image.isEmpty()) ? fileImageService.store(image) : null;

        // Y, N
        YnFlag done = (isCompleted != null) ? isCompleted : YnFlag.N;

        // 엔티티 생성/저장
        Todo todo = Todo.builder()
                .content(content)
                .isCompleted(done)
                .imageUrl(imageUrl)
                .build();

        Todo saved = repo.save(todo);
        return TodoDto.fromEntity(saved);

    }

}
