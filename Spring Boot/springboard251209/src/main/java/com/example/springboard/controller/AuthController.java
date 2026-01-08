package com.example.springboard.controller;

import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.request.auth.SignupRequest;
import com.example.springboard.dto.response.auth.AuthResponse;
import com.example.springboard.dto.response.auth.MyInfoResponse;
import com.example.springboard.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 회원 가입 - 비회원 사용
    @PostMapping("/signup")
    public ResponseEntity<Void> signup( // 결과만 받고 내용은 돌려받지 않을 거니까
            @Valid @RequestBody SignupRequest request
            ) {
        authService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 코드. POST 상태 결과
        // 삭제와 관련된 거는  noContent 써도 되는데..
        // .ok().build(); 이렇게 해도 매개변수가 없으니까 성공의 상태코드만 넘겨주긴 하지만...
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    // myinfo
    // @AuthenticationPrincipal
    @GetMapping("/myinfo")
    public ResponseEntity<MyInfoResponse> myinfo(@AuthenticationPrincipal Long memberId) { // JwtTokenFilter 클래스에서 authenticationToken에 memberId만 해줬기 때문
        return ResponseEntity.ok(authService.myinfo(memberId));
    }
}
