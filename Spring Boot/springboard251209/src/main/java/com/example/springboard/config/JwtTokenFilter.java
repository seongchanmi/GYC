package com.example.springboard.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

// 요청 -> 필터 -> 컨트롤러
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {  // 한 번 요청당 딱 한 번만 실행

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) {
        // 요청 헤드에서 토큰 추출

        // 토큰이 있고 유효하면

        // 토큰에서 정보 추출

        // 권한없이 인증 객체 생성

        // SecurityContext에 저장
    }

    // 토큰 추출
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) { // "Bearer " 띄어쓰기 주의
            return bearerToken.substring(7);
        } // "Bearer " 제거. 순수 토큰 값만 반환하겠다. 7은 인덱스번호 7번째부터 사용하겟다는 의미임 = "Bearer "까지 자른다
        return null;
    }

}


