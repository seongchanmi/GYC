package com.example.exam251215.controller;

import com.example.exam251215.dto.PageResponse;
import com.example.exam251215.dto.TodosDto;
import com.example.exam251215.service.TodosService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TodosController {

    private final TodosService todosService;

    // 등록
    @PostMapping
    public ResponseEntity<TodosDto> create(@Valid @RequestBody TodosDto dto) {
        return ResponseEntity.ok(todosService.createTodos(dto));
    }

    // 조회
    @GetMapping
    public ResponseEntity<PageResponse<TodosDto>> list(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Max(10) int size,
            @RequestParam(required = false) String keyword
    ){
        return ResponseEntity.ok(todosService.getPostList(page, size, keyword));
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<TodosDto> update(@PathVariable Long id, @RequestBody TodosDto dto) {
        return ResponseEntity.ok(todosService.updateTodos(id, dto));
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todosService.deleteTodos(id);
        return ResponseEntity.noContent().build();
    }
}
