package com.example.date1024.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamJsonController {

    @GetMapping("/param-json")
    public Map<String, Object> paramJson(@RequestParam String msg) {
        Map<String,Object> map = new HashMap<>();
        map.put("이름",msg);
        map.put("length",msg.length());
        return map; //JSON 반환
    }
}
