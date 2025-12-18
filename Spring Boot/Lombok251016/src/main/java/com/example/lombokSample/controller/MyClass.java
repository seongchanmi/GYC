package com.example.lombokSample.controller;

import org.springframework.stereotype.Component;

// 스프링이 이 클래스를 자동으로 객체로 만들어 줌(Bean 등록) Bean=등록된 객체
@Component
public class MyClass {
    public void hello(){
        System.out.println("안녕, 스프링부트? 안녕못해");

    }
}
