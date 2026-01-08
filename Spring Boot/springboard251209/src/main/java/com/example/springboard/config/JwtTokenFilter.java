package com.example.springboard.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// 요청 -> 필터 -> 컨트롤러
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {  // 한 번 요청당 딱 한 번만 실행

    private final JwtTokenProvider jwtTokenProvider;

    // 내부에서의 검사
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        // 요청 헤드에서 토큰 추출 Authorization: Bearer jhEDsDjgkl... -> "jhEDsDjgkl..." 추출
        // 헤드의 값을 Authorization으로 줌. Basic(헤더타입)을 붙이면 암호가 다 보이니까 안 붙임. Bearer(헤더타입)로 보냄
        String token = resolveToken(request);

        // 토큰이 있고 유효하면
        if(token != null && jwtTokenProvider.validateToken(token)) {
            // 토큰에서 정보 추출
            Long memberId = jwtTokenProvider.getMemberId(token);

            // 권한(role. "admin" "user")없이 "인증 객체 생성"
            // Spring Security 객체로 로그인 대상 정보
            // Controller에서 @Authentic... 이렇게 된 걸로 인증 정보를 꺼내서 쓸 수 있음
            // UsernamePasswordAuthenticationToken: 누가 로그인을 했는지 정보를 저장하는 객체
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    memberId, // principle 사용자 정보
                    null, // 비밀번호. 로그인할 때만 사용하나 JWT로 인증이 끝났으므로 null.(null인 이유는 토큰이라서 필요가 없음, 세션 방식의 로그인이면 있어야 함)
                    null // 권한(ADMIN, USER ...) "권한 사용하지 않는다"
            );

            // SecurityContextHolder에 저장
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
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


