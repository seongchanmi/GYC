package com.example.springboard.service.impl;

import com.example.springboard.domain.Member;
import com.example.springboard.domain.Post;
import com.example.springboard.domain.PostComments;
import com.example.springboard.dto.request.comment.PostCommentCreateRequest;
import com.example.springboard.dto.request.comment.PostCommentUpdateRequest;
import com.example.springboard.dto.response.comment.PostCommentResponse;
import com.example.springboard.repository.MemberRepository;
import com.example.springboard.repository.PostCommentRepository;
import com.example.springboard.repository.PostRepository;
import com.example.springboard.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommentServiceImpl implements PostCommentService {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;
    private final MemberRepository memberRepository;

    // 공통 로그인 체크
    private void requiredLogin(Long memberId) {
        if(memberId == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");
        }
    }

    //조회
    @Override
    @Transactional(readOnly = true)
    public List<PostCommentResponse> getComments(Long postId) {
        // 해당 게시글 탐색 -> 없으면 404
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "게시글을 찾지 못했습니다."));

        // 해당 게시글의 댓글 "리스트" 탐색(작성일 기준 오름차순)
        List<PostComments> postComments = postCommentRepository.findByPostOrderByCreatedAtAsc(post);
        // DTO 리스트 변환 (entity목록을 PostCommentResponse DTO로 변환)
        return postComments.stream().map(PostCommentResponse::from).toList();
        // postComments를 PostCommentResponse에 있는 from 만큼 map을 돌려서 toList에 넣어주겠다
    }

    // 작성
    @Override
    public PostCommentResponse create(Long postId, PostCommentCreateRequest request, Long memberId){
        //로그인이 됐는지, 안됐는지 확인
        requiredLogin(memberId);

        // 댓글 작성을 위한 로그인 권한 확인
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다."));

        // 해당 게시글 탐색 -> 없으면 404
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "게시글을 찾지 못했습니다."));

        // DTO -> entity
        PostComments comments = request.toEntity(post, member);

        // 저장
        PostComments saved = postCommentRepository.save(comments);

        // 응답DTO
        return PostCommentResponse.from(saved);
    }

    // 수정
    @Override
    public PostCommentResponse update(Long commentId, PostCommentUpdateRequest request, Long memberId) {
        //로그인이 됐는지, 안됐는지 확인
        requiredLogin(memberId);

        // 댓글 탐색
        PostComments postComments = postCommentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"댓글을 찾을 수 없습니다."));

        // 댓글 수정 권한 확인
        if(!postComments.getMember().getId().equals(memberId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "댓글 수정 권한이 없습니다.");
        }

        // 댓글 수정
        postComments.changeContent(request.getContent());

        return PostCommentResponse.from(postComments);
    }

    // 삭제
    @Override
    public void delete(Long commentId, Long memberId){
        //로그인이 됐는지, 안됐는지 확인
        requiredLogin(memberId);

        // 댓글 탐색
        PostComments postComments = postCommentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"댓글을 찾을 수 없습니다."));

        // 댓글 삭제 권한 확인
        if(!postComments.getMember().getId().equals(memberId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "댓글 수정 권한이 없습니다.");
        }

        // 삭제
        postCommentRepository.delete(postComments);
    }
}
