package com.example.springboard.dto.response.common;

import com.example.springboard.domain.Post;
import com.example.springboard.dto.response.post.PostListResponse;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// 페이지 관리를 위한 공통 응답 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 어떤 데이터 타입도 적용 가능 PageResponse<PostListResponse>, PageResponse<MemberResponse>, PageResponse<CommentResponse>
public class PageResponse<T> {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    // Page<Entity> -> PageResponse<DTO>

    // 제네릭 + 함수형
    // from(Page<Entity타입> page, Function<Entity타입, DTO 타입> mapper)
    public static <E, D> PageResponse<D> from(Page<E> page, Function<E,D> mapper) {
        // page.getContent() 페이징 결과 목록. 엔티티 리스트
        // .mapp(변환함수 PostListResponse :: form) 엔티티 -> DTO 변환.

        /* 변환함수 PostListResponse :: form 는 아래 주석의
            for(Post post : page.getContent()) {
                content.add(PostListResponse.form(post));
            }
            이것과 같은 기능을 해줌
         */
        List<D> content = page.getContent().stream()
                .map(mapper)
                .toList();
        return PageResponse.<D>builder()
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }

    /* 게시글 목록 전용
    public static PageResponse<PostListResponse> formPostPage(Page<Post> page) {
        List<PostListResponse> content = new ArrayList<>();

        for(Post post : page.getContent()) {
            content.add(PostListResponse.form(post));
        } // 엔티티 양식에 맞춰서 갖고 있는 수만큼 순환을 시켜

        return PageResponse.<PostListResponse> builder()
                .content(content)
                .page(page.getNumber()) // Page 객체는 jpa가 만들어 놓은 객체
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }
    */
}

/*
Page 객체 (기본적으로 가지고 있는)
목록, 현재 페이지 번호, 전체 데이터 수, 총 페이지 수 등의 정보 포함
.getContent() 실제 데이터 리스트
.getNumber() 현재 페이지 번호
.getSize() 페이지 크기(페이지네이션 처리 시 필요)
.getTotalElements() 전체 개수
.getTotalPages() 전체 페이지 수

*/