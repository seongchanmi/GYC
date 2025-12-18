package com.example.date1024.controller;

import com.example.date1024.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping("/page2")
    public String page2View() {
        return "requestWeb";
    }

    //form 전송. @ModelAttribute
    @PostMapping("/form")
    public String handleForm(UserDto user, Model model){
        model.addAttribute("msg", String.format("서버 렌더: %s(%d세) 등록 완료", user.getName(),user.getAge()));
        return "requestWeb";
    }
}
