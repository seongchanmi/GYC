package com.example.springboard.dto.response.post;

import com.example.springboard.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

// 게시글 리스트 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostListResponse {

    private Long id;
    private String title;
    private String imageUrl;
    private Integer readCount;
    private LocalDateTime createdAt;

    public static PostListResponse form(Post post) {
        return PostListResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .imageUrl(post.getImageUrl())
                .readCount(post.getReadCount())
                .createdAt(post.getCreatedAt())
                .build();
    }

}
