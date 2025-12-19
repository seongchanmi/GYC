package com.example.springboard.controller;

import com.example.springboard.dto.request.comment.PostCommentCreateRequest;
import com.example.springboard.dto.request.comment.PostCommentUpdateRequest;
import com.example.springboard.dto.response.comment.PostCommentResponse;
import com.example.springboard.service.PostCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/comments")
public class PostCommentController {

    private final PostCommentService postCommentService;

    // 댓글 조회
    @GetMapping
    public ResponseEntity<List<PostCommentResponse>> getComments(
            @PathVariable Long postId
    ) {
        return ResponseEntity.ok(postCommentService.getComments(postId));
    }

    // 댓글 작성
    @PostMapping
    public ResponseEntity<PostCommentResponse> createComment(
            @PathVariable Long postId,
            @Valid @RequestBody PostCommentCreateRequest request
            ) {
    return ResponseEntity.ok(postCommentService.create(postId, request));
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<PostCommentResponse> updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @Valid @RequestBody PostCommentUpdateRequest request
            ) {
        PostCommentResponse response = postCommentService.update(commentId,request);
        return ResponseEntity.ok(response);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long commentId
    ) {
        postCommentService.delete(commentId);
        return ResponseEntity.noContent().build();
    }

}
