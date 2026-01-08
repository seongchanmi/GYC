package com.example.springboard.dto.response.post;

import com.example.springboard.domain.Post;
import com.example.springboard.dto.response.common.MemberResponse;
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
    private MemberResponse author; // 작성자 (id, nickname)
    private String imageUrl;
    private Integer readCount;
    private LocalDateTime createdAt;

    public static PostListResponse form(Post post) {
        return PostListResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(MemberResponse.from(post.getMember())) // 작성자 매핑
                .imageUrl(post.getImageUrl())
                .readCount(post.getReadCount())
                .createdAt(post.getCreatedAt())
                .build();
    }

}
