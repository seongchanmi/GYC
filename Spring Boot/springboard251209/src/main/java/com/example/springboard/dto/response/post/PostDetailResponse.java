package com.example.springboard.dto.response.post;

import com.example.springboard.domain.Post;
import com.example.springboard.dto.response.common.MemberResponse;
import lombok.*;

import java.time.LocalDateTime;

// 게시글 상세 응답 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDetailResponse {

    private Long id;
    private String title;
    private MemberResponse author;
    private String content;
    private String imageUrl;
    private Integer readCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostDetailResponse form(Post post) {
        return PostDetailResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(MemberResponse.from(post.getMember())) // 작성자 매핑
                .content(post.getContent())
                .imageUrl(post.getImageUrl())
                .readCount(post.getReadCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
