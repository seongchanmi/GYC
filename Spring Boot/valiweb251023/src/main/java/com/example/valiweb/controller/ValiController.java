package com.example.valiweb.controller;

import com.example.valiweb.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ValiController {

    //입력 /userin
    @GetMapping("/input")
    public String showInput(@ModelAttribute("userDto") UserDto user) {
        return "form/userInput";
    }

    //출력 /userout
    /*
    @PostMapping("/output")
    public String userOutput(@Valid UserDto user, // DTO에 선언된 애너테이션을 통해 검증
                             BindingResult br, //에러 발생시 처리 영역, 반드시 검증 대상 파라미터 다음에 작성
                             Model model) {
        if(br.hasErrors()) { // 넘겨 받은 대상에 에러가 있으면
            return "form/userInput"; // 입력 화면으로
        } else{
            model.addAttribute("dto", user);
            return "form/userOutput"; // 출력 화면으로
        }
    }
     */
    @PostMapping("/output")
    public String userOutput(@Valid UserDto user, BindingResult bs, Model model) {
        if (bs.hasErrors()) { // 넘겨 받은 대상에 에러가 있으면
            System.out.println(bs.hasErrors());
            return "form/userInput"; // 입력 화면으로
        } else {
            model.addAttribute("dto", user);
            return "form/userOutput";
        }

    }

    @GetMapping("/list")
    public String listView(Model model){
        model.addAttribute("title","감귤류");

        List<String> fruits = List.of("유라조생","타이벡","황금향","노지감귤");
        model.addAttribute("fruit", fruits); //fruit가 있는 곳에 fruits를 돌려주겠다
        return "list";
    }
}
