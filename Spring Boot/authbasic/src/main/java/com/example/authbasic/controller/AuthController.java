package com.example.authbasic.controller;

import org.springframework.web.bind.annotation.*;

/*
GET     /api/auth/ :누구나 조회 가능
POST    /api/auth/ : 로그인한 사람만 가능
DELETE  /api/auth/{id}: ADMIN만 가능
 */

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping
    public String list() {
        return "OK: 누구나 조회 가능";
    }

    @PostMapping
    public String create() {
        return "OK: 로그인한 사용자만 등록 가능";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return "OK: ADMIN만 삭제 가능 id=" + id;
    }
}
