package com.example.thymeweb.controller;

import com.example.thymeweb.dto.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeController {

    @GetMapping("/form1")
    public String formEx1(){
        return "form/formEx1"; // templates 폴더 바로 아래에 이 html 문서가 있는 게 아니라서 앞에 form/formEx1 까지 해줘야 경로를 찾음
    }

    @PostMapping("result1")
    public String output1(@RequestParam String username,
                          @RequestParam int userage,
                          Model model){
        model.addAttribute("name", username);
        model.addAttribute("age", userage);
        return "form/result1";
    }

    // /form2?name="한라봉"&age="22"-> UserForm(name="한라봉", age="22") 형태로 자동 저장되어 모델에 포함
    @GetMapping("form2")
    public  String formEx2(@ModelAttribute("UserForm") UserForm form){
        return "form/formEx2";
    }

    @PostMapping("result2")
    public String output2(@ModelAttribute("UserForm") UserForm form, Model model) {
        model.addAttribute("user",form);
        return "form/result2";
    }
}
