package com.example.springboard.config;

import com.example.springboard.domain.Member;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

// 토큰 발급소: 토큰 생성, 검증. 정보를 꺼내는 일을 함
// 서버 -> 토큰 발급 -> 요청할 때마다 토큰 확인
@Component
public class JwtTokenProvider {

    // application.properties에서 주입
    // 비밀키
    private final String secret;
    // 만료기간
    private final long expiration;

    // 실제 암호화 키 (변환된 키 저장용)
    private SecretKey secretKey;

    public JwtTokenProvider(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expiration
    ) {
        this.secret = secret;
        this.expiration = expiration;
    } // value 어노테이션 사용하면 final이랑 충돌이 일어나서 직접 주입해준다. (무슨 말인지는 모르겠음)

    // 객체 생성 후 자동 실행(초기화)
    @PostConstruct
    public void init() {
        // 문자열 비밀키를 실제 암호화 키로 변환
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // 실제 사용
    // 로그인 시 JWT 생성
    public String generateToken(Member member) {
        Date now = new Date(); // 현재시간
        Date expiry = new Date(now.getTime() + expiration); // 1시간

        // Jwts.builder() : 객체 반환 메서드
        // .compact(); : String 반환 메서드
        return Jwts.builder()
                .subject(member.getEmail()) // 주제, 메인 설정. member에 있는 email을 메인으로 한다. 아이디로 해도 되고 아무튼 그럼
                .claim("memberId", member.getId()) // 추가 정보
                .issuedAt(now) // 발급 시간
                .expiration(expiry) // 만료 시간
                .signWith(secretKey) // 비밀키 서명
                .compact(); // 문자열 반환
    }

    // JWT 토큰 유효성 검사 (서명, 만료 시간)
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(secretKey) // 서명 확인
                    .build()
                    .parseSignedClaims(token); // 파싱. 데이터 추출
            return true;
        } catch (Exception e) {
            // 위조되거나 만료 토큰
            return false;
        }
    }

    // JWT에서 정보 추출
    // MemberId
    public Long getMemberId(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("memberId", Long.class); // 추출
    }

    // email
    public String getEmail(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject(); // 이메일 추출
    }
}

/*

생성되는 토큰
{
"sub" : "abc@abc.com",
"memberId" : 1,
"iat" : 12342123,
"exp" : 12345670
}

*/