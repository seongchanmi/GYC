package com.example.springboard.service;

import com.example.springboard.dto.request.post.PostCreateRequest;
import com.example.springboard.dto.request.post.PostUpdateRequest;
import com.example.springboard.dto.response.common.PageResponse;
import com.example.springboard.dto.response.post.PostDetailResponse;
import com.example.springboard.dto.response.post.PostListResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.jspecify.annotations.Nullable;

// 설계도(비즈니스 규칙) 역할
// 구현체를 따로 만들면 파일 업로드 방식 등의 비즈니스 로직을 언제든 변경 가능
public interface PostService {

    // 프론트에서 넘어온 PostCreateRequest(제목, 내용, 이미지주소)를 받아 저장 후 전체 데이터로 응답
    // 게시글 생성
    // 프론트에서 넘어온 데이터를 PostCreateRequest DTO로 받아 저장 후 응답
    // Request DTO -> entity 변환, .save() :JPA repository가 가지고 있는 저장 기능 -> response DTO 반환
    PostDetailResponse createPost(PostCreateRequest request);

    // 게시글 목록 조회 + 검색 + 페이징
    PageResponse<PostListResponse> getPostList(@Min(0) int page, @Max(10) int size, String keyword);

    // 게시글 상세 조회 + 조회수 증가
    PostDetailResponse getPostDetail(Long id);

    PostDetailResponse updatePost(Long id, PostUpdateRequest request);

    void deletePost(Long id);

    // 게시글 삭제

    // 게시글 수정
}
