package com.example.date1024.controller;

import com.example.date1024.domain.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestBodyController {

    @PostMapping("/user2")
    public UserDto saveUser2(@RequestBody UserDto user) {
        user.setAge(user.getAge()-1);
        return user;
    }

}
