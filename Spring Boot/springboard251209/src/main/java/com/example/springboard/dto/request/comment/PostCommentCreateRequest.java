package com.example.springboard.dto.request.comment;

import com.example.springboard.domain.Member;
import com.example.springboard.domain.Post;
import com.example.springboard.domain.PostComments;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

// 댓글 작성 요청 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCommentCreateRequest {

    @NotBlank(message = "댓글 내용을 입력하세요.")
    private String content;

    // dto -> entity 로 변환
    public PostComments toEntity(Post post, Member member) {
        return PostComments.builder()
                .member(member)
                .post(post)
                .content(content)
                .build();
    }
}
