package com.example.springboard.service;

import com.example.springboard.config.JwtTokenProvider;
import com.example.springboard.domain.Member;
import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.request.auth.SignupRequest;
import com.example.springboard.dto.response.auth.AuthResponse;
import com.example.springboard.dto.response.auth.MyInfoResponse;
import com.example.springboard.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    public void signup(@Valid SignupRequest request) {
        // 이메일 중복 확인
        if(memberRepository.existsByEmail(request.getEmail())) { // find와 exists의 차이 지피티한테 물어보기
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다.");
    }
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Member 저장
        Member member = request.toEntity(encodedPassword);
        memberRepository.save(member);
    }

    // 로그인
    public AuthResponse login(LoginRequest request) {

        // 회원 조회
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 맞지 않습니다."));
        // 이메일(혹은 비밀번호)이 맞지 않다고 정확하게 말하지 않는 이유는 보안 때문

        // 비밀번호 검증
        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 맞지 않습니다.");
        }

        // JWT 토큰 생성
        String token = jwtTokenProvider.generateToken(member);

        return new AuthResponse(token, "Bearer");
    }

    // 내정보
    public MyInfoResponse myinfo(Long memberId) {
        if(memberId == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");
        }
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다."));

        return MyInfoResponse.from(member);
    }
}
