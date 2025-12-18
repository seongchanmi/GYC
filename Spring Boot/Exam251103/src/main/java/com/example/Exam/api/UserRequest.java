package com.example.Exam.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequest {

    @NotBlank(message = "이름 필수 작성")
    @Size(max = 30, message = "이름은 최대 30자까지 가능합니다.")
    private String name;

    @NotNull(message = "나이 필수 작성")
    private Integer age;
}
