package com.example.webview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {

    // localhost:8080/view
    @GetMapping("/view")
    public String hello(){
        return "index";
    }
}
