package com.example.lombokSample;

import com.example.lombokSample.controller.MyClass;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
스프링부트 애플리케이션의 시작을 알리는 어노테이션
@SpringBootApplication -> 여러개의 어노테이션이 합쳐져 있는 상태
설정, 자동실행을 담당하는 어노테이션
 */
@SpringBootApplication
public class LombokSampleApplication {

    // 스프링이 알아서 객체를 주입해 줌
    @Autowired
    private MyClass my;

    public static void main(String[] args) {
        SpringApplication.run(LombokSampleApplication.class, args);
        System.out.println("스프링 부트에서도 print메서드 사용 가능 sout");
        System.out.println("정렬 단축키는 ctrl+alt+l");
    }

    @PostConstruct // main 메서드 실행 후 바로 다음에 자동 실행
    public void runAfter(){
        my.hello();
    }
}
