package com.example.springboard.repository;

import com.example.springboard.domain.Post;
import com.example.springboard.domain.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComments, Long> {

    // 특정 게시글의 댓글 작성일 오름차순
    List<PostComments> findByPostOrderByCreatedAtAsc(Post post);

    // 삭제 메서드
    void deleteByPostId(Long postId);
}
