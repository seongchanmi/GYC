package com.example.springboard.dto.request.post;

import com.example.springboard.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

// 게시글 작성 요청 시 사용 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateRequest {

    @NotBlank(message = "제목 작성 필수")
    @Size(max = 200, message = "200자 이하로 작성하세요.")
    private String title;

    @NotBlank(message = "내용 작성 필수")
    private String content;
    private String imageUrl;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .imageUrl(imageUrl)
                .build();
    }
}
