package com.example.thymeweb.dto;

import lombok.Data;

@Data
public class UserForm {

    private String name;
    private Integer age; // null 허용
    private String phone;
    private String email;
}
