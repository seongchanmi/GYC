package com.example.springboard.dto.response.comment;

import com.example.springboard.domain.PostComments;
import lombok.*;

import java.time.LocalDateTime;

// 댓글 응답 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCommentResponse {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // entity -> dto
    public static PostCommentResponse from(PostComments comments) {
        return PostCommentResponse.builder()
                .id(comments.getId())
                .content(comments.getContent())
                .createdAt(comments.getCreatedAt())
                .updatedAt(comments.getUpdatedAt())
                .build();
    }
}
