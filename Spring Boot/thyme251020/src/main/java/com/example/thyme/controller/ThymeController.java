package com.example.thyme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/api") // -> 이걸 넣어주면 localhost:8080/api/show로 접속이 됨
public class ThymeController {

    @GetMapping("/show") // 바로 접속하는 방법 localhost:8080/show
    public String showView() {
        return "index"; //타임리프가 알아서 resources/templates/index.html 를 찾아서 출력을 해줌
    }

    @GetMapping("/input")
    public String inputView() {
        return "input";
    }

    // 조회할 때 주로 사용, 데이터값이 URL에 보임 (?val=타이백)
    @GetMapping("/result")
    public String resultGet(@RequestParam String val, Model model) { // @RequestParam는 http 요청 메서드의 매개변수로 받음
        model.addAttribute("value", val);
        return"output";
    }

    // 등록, 저장 등에 주로 사용, 데이터값이 URL에 안 보임. 폼 내부에서 서버로 전송. 회원가입, 로그인
    @PostMapping("/result")
    public String resultPost(@RequestParam String val, Model model) {
        model.addAttribute("value", val);
        return"output";
    }
}

