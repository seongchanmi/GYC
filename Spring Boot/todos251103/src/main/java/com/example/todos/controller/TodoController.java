package com.example.todos.controller;

import com.example.todos.api.MemberRequest;
import com.example.todos.api.MemberResponse;
import com.example.todos.dto.TodoDto;
import com.example.todos.entity.Todo;
import com.example.todos.entity.YnFlag;
import com.example.todos.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j //Logging 프레임워크를 사용할 수 있게끔 해주는. 프로그램이 실행되는 동안 동작을 기록함. System.out.println은 단순 출력이라 실제 운영 서버에서는 사용하지 않음
@RestController //웹뷰로 뭘 할 건 아니라서.. 그냥 restcontroller로..
@RequestMapping("/todos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // CORS(보안정책) 허용
public class TodoController {

    private final TodoService service;

    // JSON 전용 등록
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // POST는 본문에서 데이터가 JSON의 형태로 넘어옴.  GET은 URL을 통해서 데이터가 넘어옴
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto dto){ // http 요청 body에서 JSON을 Todo 객체로 변환해서 받음
        log.info("============dto:" + dto + " / " + dto.getContent() + " / " + dto.getIsCompleted());
        Todo saved = service.register(dto); //입력받는 데이터가 여러개면 dto 자체를 받는 것이 편함. (원래는 dto.getContent()였음)
        return ResponseEntity.ok(TodoDto.fromEntity(saved));
    }

    // 이미지 포함 등록 multipart/form-data
    // Multipart/form-data : 여러 파트로 나눠 전송하는 방식
    // <form method="post" enctype="multipart/form-data"></form> 프론트에서 이런식으로 작성을 해야 값이 넘어감
    // @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoDto> createTodoImage(
            @RequestPart("content") String content,
            @RequestPart(value = "isCompleted", required = false)YnFlag isCompleted,
            @RequestPart(value = "imageUrl", required = false)MultipartFile image
            ){
        log.info("content: " + content + "/ imageUrl: " + image); // 콘솔창에서 content와 image가 보고 싶으면 로그를 사용해서 띄우기
        TodoDto saved = service.registerImage(content, isCompleted, image);
        return ResponseEntity.ok(saved);
    }

    //전체 조회
    @GetMapping
    public ResponseEntity<List<TodoDto>> getTodos(){
        List<TodoDto> list = service.findAll().stream()
                .map(todo -> TodoDto.fromEntity(todo))
                .toList();
        return ResponseEntity.ok(list);
    }

    //개별 조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> contentFindById(@PathVariable int id){
        Todo todo = service.findById(id);
        return ResponseEntity.ok(TodoDto.fromEntity(todo));
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id){ //반환 받을 값이 없기 때문에 Void 를 넣어줌
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //전체 수정
    @PutMapping("/{id}") //patch는 어느 하나만 수정할 때, 전체 수정을 할 때는 put이 좋음
    public ResponseEntity<TodoDto> updateTodo(@PathVariable int id, @RequestBody TodoDto dto){
        Todo updated = service.updateContent(id, dto); //dto 전체를 넘겨줘도 되고, 아니면 dto.getContent()로 딱 찝어서 그 데이터만 넘겨줘도 되고
        return ResponseEntity.ok(TodoDto.fromEntity(updated)); //값을 받아서 뿌릴?내용을 볼거다! 하면 이렇게 작성하고, 값을 안 받을거면 삭제처럼 .noContent()로 하면 됨
    }
/*
    @PutMapping("/{id}") //patch는 어느 하나만 수정할 때, 전체 수정을 할 때는 put이 좋음
    public ResponseEntity<TodoDto> updateTodo(@PathVariable int id, @RequestBody TodoDto dto){
        Todo updated = service.updateContent(id, dto); //dto 전체를 넘겨줘도 되고, 아니면 dto.getContent()로 딱 찝어서 그 데이터만 넘겨줘도 되고
        return ResponseEntity.ok(TodoDto.fromEntity(updated)); //값을 받아서 뿌릴?내용을 볼거다! 하면 이렇게 작성하고, 값을 안 받을거면 삭제처럼 .noContent()로 하면 됨
    }
 */

    //Y,N 수정만
    @PatchMapping("/{id}/done") // PATCH >>  http://localhost:8080/todos/25/done 으로 접속
    public ResponseEntity<TodoDto> updateYn(@PathVariable int id, @RequestBody TodoDto dto){
        Todo updated = service.updateYn(id, dto.getIsCompleted());
        return ResponseEntity.ok(TodoDto.fromEntity(updated));
    }
    // PATCH >>  http://localhost:8080/todos/25/done 으로 접속
}
