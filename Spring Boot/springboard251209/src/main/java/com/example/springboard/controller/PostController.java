package com.example.springboard.controller;

import com.example.springboard.dto.request.post.PostCreateRequest;
import com.example.springboard.dto.request.post.PostUpdateRequest;
import com.example.springboard.dto.response.common.PageResponse;
import com.example.springboard.dto.response.post.PostDetailResponse;
import com.example.springboard.dto.response.post.PostListResponse;
import com.example.springboard.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 데이터만 처리를 할 거라 @RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {

    // @RequiredArgsConstructor가 알아서 만들어줘야 하기 때문에 final을 붙여서 상수처리
    private final PostService postService;

    // 게시글 등록
    @PostMapping // 프론트로부터 받은 값을 (JSON으로 받아서) 자바 객체로 변환, 서비스로 넘겨줌
    public ResponseEntity<PostDetailResponse> create(@Valid @RequestBody PostCreateRequest request) { // @RequestBody에 값을 숨겨서 보내줌?
        return ResponseEntity.ok(postService.createPost(request));
    }

    // 게시글 목록 조회 + 검색 + 페이징
    // /api/posts? 물음표 뒤에 오는 것들이 쿼리
    // /api/posts?page=0&size=10&keyword=스프링부트
    @GetMapping
    public ResponseEntity<PageResponse<PostListResponse>> list(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Max(10) int size,
            @RequestParam(required = false) String keyword
    ) {
        return ResponseEntity.ok(postService.getPostList(page, size, keyword));
    }

    // 게시글 상세 조회 + 조회수 증가
    @GetMapping("/{id}")
    public ResponseEntity<PostDetailResponse> detail(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostDetail(id));
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<PostDetailResponse> update(
            @PathVariable Long id,
            @RequestBody PostUpdateRequest request
    ) {
        return ResponseEntity.ok(postService.updatePost(id, request));
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
