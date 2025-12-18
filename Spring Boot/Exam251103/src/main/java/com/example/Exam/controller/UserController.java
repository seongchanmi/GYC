package com.example.Exam.controller;

import com.example.Exam.api.UserRequest;
import com.example.Exam.api.UserResponse;
import com.example.Exam.entity.User;
import com.example.Exam.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest req){
        User saved = service.register(req.getName(), req.getAge());
        return ResponseEntity.ok(UserResponse.form(saved));
    }

}
