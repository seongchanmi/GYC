package com.example.Exam.api;

import com.example.Exam.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private Integer age;

    public static UserResponse form(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}
