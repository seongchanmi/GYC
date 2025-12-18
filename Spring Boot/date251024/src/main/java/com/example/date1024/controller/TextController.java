package com.example.date1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextController {

    @GetMapping("/text")
    @ResponseBody // 웹뷰(html문서)로 렌더링하는 게 아닌 http 응답 본문(body)에 직접 넣어 전송
    public String senText(){
        return "서버에서 보낸 단순 텍스트";
    }
}
