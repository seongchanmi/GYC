package com.example.date1024.controller;

import com.example.date1024.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @GetMapping("/user1")
    @ResponseBody
    public UserDto getUser() {
        // JSON으로 자동 변환되어 전송
        return new UserDto("유라조생", 10);
    }

}

/*
 현재 가장 많이 쓰는 데이터 전달 문서 타입 JSON
 {key: value} 로 구성
{key: value, key: value, key: value, ..... , key: value}
{"문자열": "문자열", "문자열": 숫자, "문자열": 객체}  >>> 무조건 큰 따옴표
 */