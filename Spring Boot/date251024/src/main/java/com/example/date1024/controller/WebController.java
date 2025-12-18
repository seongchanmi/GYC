package com.example.date1024.controller;

import com.example.date1024.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// WebController 와 WebApiController 둘의 차이를 보기 위해
// @Controller @RestController @RequestMapping 의 차이

@Controller
public class WebController {

    // HTML 문서 렌더링
    @GetMapping("/page")
    public String pageView(Model model) {
        model.addAttribute("title","웹페이지");
        model.addAttribute("name", "한라봉");
        return "page";
    }

    // Text 응답
    @GetMapping("text2")
    @ResponseBody
    public String text2View() {
        return "text2 응답";
    }

    //JSON 응답
    @GetMapping("user3")
    @ResponseBody // 웹으로 보낼 거면 ResponseBody를 꼭 붙어야 함
    public UserDto user3View(
            @RequestParam (defaultValue = "천혜향") String name,
            @RequestParam (defaultValue = "20") int age
            ){
        return new UserDto(name, age);
    }

}
