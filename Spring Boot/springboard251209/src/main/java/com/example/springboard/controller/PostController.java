package com.example.springboard.controller;

import com.example.springboard.dto.request.post.PostCreateRequest;
import com.example.springboard.dto.request.post.PostUpdateRequest;
import com.example.springboard.dto.response.common.PageResponse;
import com.example.springboard.dto.response.post.PostDetailResponse;
import com.example.springboard.dto.response.post.PostListResponse;
import com.example.springboard.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController // 데이터만 처리를 할 거라 @RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
// @CrossOrigin(origins = "http://localhost:5173") WebConfig 있으면 작성 안해도 된다. 주석처리 해도 프론트와 통신이 가능하다
@Tag(name = "게시글", description = "게시글 CRUD API") // 한 섹션의 제목이 됨
public class PostController {

    // @RequiredArgsConstructor가 알아서 만들어줘야 하기 때문에 final을 붙여서 상수처리
    private final PostService postService;

    // 게시글 등록
    @PostMapping // 프론트로부터 받은 값을 (JSON으로 받아서) 자바 객체로 변환, 서비스로 넘겨줌
    @Operation(summary = "게시글 등록", description = "새로운 글 작성. 로그인한 사람만 작성 가능") // Swagger 각 엔드포인트에 대한 설명
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "게시글 생성 성공", content = @Content(schema = @Schema(implementation = PostDetailResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 - 필수 항목 누락 혹은 유효성 검증 실패"),
            @ApiResponse(responseCode = "401", description = "인증 필요 - 로그인이 필요합니다.")
    })
    public ResponseEntity<PostDetailResponse> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "게시글 작성 요청 데이터",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = PostCreateRequest.class),
                            examples = {
                                    @ExampleObject(
                                            name = "예시",
                                            value = """
                                                    {
                                                    "title" : "첫 번째 글",
                                                    "content" : "게시판 테스트 내용입니다.",
                                                    "imageUrl" : "/image/test.png"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
            @Valid @RequestBody PostCreateRequest request, // @RequestBody에 값을 숨겨서 보내줌?
            @AuthenticationPrincipal Long memberId
            ) {
        return ResponseEntity.ok(postService.createPost(request, memberId));
    }

    // 게시글 목록 조회 + 검색 + 페이징
    // /api/posts? 물음표 뒤에 오는 것들이 쿼리
    // /api/posts?page=0&size=10&keyword=스프링부트
    @GetMapping
    public ResponseEntity<PageResponse<PostListResponse>> list(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Max(10) int size,
            @RequestParam(required = false) String keyword
    ) {
        return ResponseEntity.ok(postService.getPostList(page, size, keyword));
    }

    // 게시글 상세 조회 + 조회수 증가
    @GetMapping("/{id}")
    public ResponseEntity<PostDetailResponse> detail(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostDetail(id));
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<PostDetailResponse> update(
            @PathVariable Long id,
            @RequestBody PostUpdateRequest request,
            @AuthenticationPrincipal Long memberId
    ) {
        return ResponseEntity.ok(postService.updatePost(id, request, memberId));
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @AuthenticationPrincipal Long memberId) {
        postService.deletePost(id, memberId);
        return ResponseEntity.noContent().build();
    }
}
