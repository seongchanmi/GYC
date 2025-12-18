package com.example.springboard.service.impl;

import com.example.springboard.domain.Post;
import com.example.springboard.dto.request.post.PostCreateRequest;
import com.example.springboard.dto.request.post.PostUpdateRequest;
import com.example.springboard.dto.response.common.PageResponse;
import com.example.springboard.dto.response.post.PostDetailResponse;
import com.example.springboard.dto.response.post.PostListResponse;
import com.example.springboard.repository.PostRepository;
import com.example.springboard.service.FileService;
import com.example.springboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

// 실제 비즈니스 로직 처리 (CRUD 작업)
// entity 조회, DTO <-> entity 변환, 비즈니스 로직 처리
@Service
@RequiredArgsConstructor // 자동으로 생성자를 만들어주는 역할, 근데 조건이 상수만 만들어주기 때문에 아래 private final PostRepository postRepository;에서 final을 써줘야 하는 것임
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final FileService fileService;

    // 게시글 생성
    // 프론트에서 넘어온 데이터를 PostCreateRequest DTO로 받아 저장 후 응답
    // Request DTO -> entity 변환, .save() :JPA repository가 가지고 있는 저장 기능 -> response DTO 반환
    @Override
    public PostDetailResponse createPost(PostCreateRequest request) {
        // DTO를 entity로 변환
        Post post = request.toEntity();
        // 저장
        Post saved = postRepository.save(post);
        // DTO 변환해서 반환
        return PostDetailResponse.form(saved);
    }

    // 게시글 목록 조회 + 검색 + 페이징
    @Override
    @Transactional(readOnly = true)
    public PageResponse<PostListResponse> getPostList(int page, int size, String keyword) {

        // pageable  객체 생성. 페이지 번호, 한 페이지 안에 데이터 수, 정렬 기준
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        // Sort.by(Sort.Direction.DESC, "id") id를 기준으로 내림차순 하겠다~

        // 검색
        Page<Post> postPage = findPostPage(keyword, pageable);

        // DTO로 반환
        // postPage 안에 있는 entity 목록을 PostListResponse DTO로 변환 -> PageResponse 형태로 반환
        return PageResponse.from(postPage, PostListResponse::form);
    }

    private Page<Post> findPostPage(String keyword, Pageable pageable) {
        // 검색어가 없으면 전체 조회
        if(keyword == null || keyword.isBlank()){
            return postRepository.findAll(pageable);
        }

        // 검색어가 있으면 제목/내용에서 검색
        return postRepository.findByTitleContainingIgnoreCaseOrContentContaining(
                keyword,
                keyword,
                pageable);
    }

    // 게시글 상세 조회 + 조회수 증가
    @Override
    public PostDetailResponse getPostDetail(Long id) {
        // id 조회, 없으면 예외 처리
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 글을 찾을 수 없습니다."));

        // 조회수 증가
        post.increaseReadCount();

        // 상세정보 entity를 DTO로 변환해서 반환
        return PostDetailResponse.form(post);
    }

    // 게시글 수정
    @Override
    public PostDetailResponse updatePost(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 글을 찾을 수 없습니다."));

        // 엔티티 업데이트 메서드
        post.update(request.getTitle(), request.getContent(), request.getImageUrl());

        // response DTO 변환 후 반환
        return PostDetailResponse.form(post);
    }

    // 게시글 삭제
    @Override
    public void deletePost(Long id) {
        // 아이디 조회
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 글을 찾을 수 없습니다."));

        // 삭제
        fileService.deleteImage(post.getImageUrl());
        postRepository.delete(post);
    }
}
