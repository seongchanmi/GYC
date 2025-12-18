package com.example.springboard.repository;

import com.example.springboard.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// Post Entity와 DB를 연결해서 기본 CRUD 기능을 제공 받음
// JPA의 기능을 사용하기 위해서 인터페이스 상속 받음
public interface PostRepository extends JpaRepository<Post, Long> {
    // 검색 메서드
    // Pageable 페이지 번호, 크기, 정렬... 등을 다 불러와 줌. PageRequest.of(0, 10, Sort.by("id").descending);
    Page<Post> findByTitleContainingIgnoreCaseOrContentContaining(
            String title, String content, Pageable pageable
    );

    // Page<Post> findByMember(Member Member, Pageable pageable); 회원이 작성한 게시글을 찾고 싶다. 몇개인지 찾고 있다...
}

/*
findBy + 필드명 + 조건 (+ 연결 조건 + 필드명 + 조건 ...)
규칙에 맞는 형식을 만들면 자동으로 쿼리문을 생성
:
findBy 찾음
Title 타이틀 필드
Containing 해당 필드에 특정 문자열이 포함된 데이터
IgnoreCase 대소문자 무시
Or 혹은
Content 컨텐트 필드
 */