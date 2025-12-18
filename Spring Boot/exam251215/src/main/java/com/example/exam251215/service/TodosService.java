package com.example.exam251215.service;

import com.example.exam251215.dto.PageResponse;
import com.example.exam251215.dto.TodosDto;
import com.example.exam251215.entity.Todos;
import com.example.exam251215.repository.TodosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TodosService {

    private final TodosRepository todosRepository;

    // 등록
    public TodosDto createTodos(TodosDto dto) {
        Todos todos = dto.toEntity();
        Todos saved = todosRepository.save(todos);
        return TodosDto.fromEntity(saved);
    }

    // 조회
    @Transactional(readOnly = true)
    public PageResponse<TodosDto> getPostList(int page, int size, String keyword) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        // 검색
        Page<Todos> postPage = findPostPage(keyword, pageable);
        return PageResponse.from(postPage, TodosDto::fromEntity);
    }

    private Page<Todos> findPostPage(String keyword, Pageable pageable) {
        // 검색어가 없으면 전체 조회
        if(keyword == null || keyword.isBlank()){
            return todosRepository.findAll(pageable);
        }

        // 검색어가 있으면 제목/내용에서 검색
        return todosRepository.findByTitleContainingIgnoreCaseOrContentContaining(
                keyword,
                keyword,
                pageable);
    }

    // 수정
    public TodosDto updateTodos(Long id, TodosDto dto) {
        Todos todos = todosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 글을 찾을 수 없습니다."));
        todos.update(dto.getContent());
        return TodosDto.fromEntity(todos);
    }

    // 삭제
    public void deleteTodos(Long id) {
        Todos todos = todosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 글을 찾을 수 없습니다."));
        todosRepository.delete(todos);
    }


}
