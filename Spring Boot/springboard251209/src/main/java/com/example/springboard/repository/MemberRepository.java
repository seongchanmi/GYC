package com.example.springboard.repository;

import com.example.springboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 로그인시 이메일로 회원 찾기
    // Optional: "있을 수도 있고, 없을 수도 있다"
    Optional<Member> findByEmail(String email);
    // 회원 가입시 이메일 중복 체크
    boolean existsByEmail(String email);
}
