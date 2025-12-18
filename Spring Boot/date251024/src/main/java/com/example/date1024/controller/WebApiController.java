package com.example.date1024.controller;

import com.example.date1024.domain.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// WebController 와 WebApiController 둘의 차이를 보기 위해
// @Controller @RestController @RequestMapping 의 차이

@RestController //이 클래스 전체가 데이터로 넘겨줘야 할 내용일 경우에 @RestController로 어노테이션 적용
// WebController와 비교했을 때 각 필드에 @ResponseBody 어노테이션을 적용 안해도 같은 결과를 볼 수 있음?? >>html은 조금 다른 듯
@RequestMapping("/api")
public class WebApiController { // WebController 와 WebApiController 둘의 차이를 보기 위해

    // html
    @GetMapping("/page")
    public String pageView(Model model) {
        model.addAttribute("title","웹페이지");
        model.addAttribute("name", "한라봉");
        return "page";
    }

    // Text 응답
    @GetMapping("text2")
    public String text2View() {
        return "text2 응답";
    }

    //JSON 응답
    @PostMapping ("user3") // Post로 보내면 데이터를 숨겨서 넘겨준다고??
    public UserDto user3View(@RequestBody UserDto user) {
        user.setAge(user.getAge()+1);
        return user;
    }
}
