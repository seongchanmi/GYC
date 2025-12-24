package com.example.springboard.dto.response.auth;

/*

로그인 성공여부 확인
JWT 토큰만 전달
사용자 정보는 포함하지 않음

로그인 요청시
전달될 때 JSON형태로 전달
{
"accessToken":"sdkfjhlkj4j6lkj2kj@#Jlk", // JWT 토큰
"tokenType":"Bearer" // 토큰 타입
}

 */

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponse {

    private String accessToken;
    private String tokenType;

}
