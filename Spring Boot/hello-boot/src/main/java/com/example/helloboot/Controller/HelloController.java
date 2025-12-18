package com.example.helloboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
@Controller // 스프링이 자동으로 컨트롤러 역할을 하는 객체를 생성(Bean 자동 등록)
@ResponseBody // 응답 본문
 */
@RestController // http 통신 요청을 받아 호출하고 반환 // @Controller 와 @ResponseBody 의 기능을 한 번에 해주는 것
public class HelloController {

    // @RequestMapping(value = "hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello(){
        return "hello, Spring Boot";
    }

    @GetMapping("view") // view 앞에 슬래시 (/) 넣어도 되고 안 넣어도 되고
    public String webView(){
        return "index";
    }

}

// localhost:8080/hello