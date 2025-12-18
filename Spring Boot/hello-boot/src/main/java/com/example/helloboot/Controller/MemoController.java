package com.example.helloboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// :8080/hello
// :8080/api/memo
@RestController // 독립적으로 HTTP 요청 처리 가능. 패키지 안에 URL이 겹치지 않으면 여러 개의 컨트롤러 사용 가능
@RequestMapping("/api/memo")
public class MemoController {

    // localhost:8080/api/memo/hello
    @GetMapping("/hello")
    public String hello(){
        return "memo"; // 문자열 반환
    }
}
