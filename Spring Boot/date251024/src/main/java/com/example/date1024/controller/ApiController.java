package com.example.date1024.controller;

import com.example.date1024.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    // @RequestParam
    @GetMapping("/user")
    public Map<String, Object> getUserParam(@RequestParam String name,
                                            @RequestParam int age){
        return Map.of("type","@RequestParam", "name", name, "age", age);
    }

    // @ModelAttribute x-www-form-urlencoded
    @PostMapping("/form")
    public Map<String, Object> postUser(@ModelAttribute UserDto user) {
        return Map.of("type","@ModelAttribute", "name", user.getName(), "age", user.getAge());
    }

    // @RequestBody JSON
    @PostMapping("/postUser")
    public Map<String, Object> postRequestBody(@RequestBody UserDto user) {
        return Map.of("type","@RequestBody", "name", user.getName(), "age", user.getAge()+1);
    }


}
