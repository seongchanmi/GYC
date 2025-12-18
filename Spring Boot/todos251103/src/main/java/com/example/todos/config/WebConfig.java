package com.example.todos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//스프링 MVC 설정을 수정, 추가
//정적 리소스, CORS  ...

//스프링 설정 파일
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}") //application.properties에 있는 file.upload-dir=c:/chnmwork/uploads 주소를 자동으로 가져와줌
    private String uploadDir; // 이때의 변수명은 원하는 거 아무거나 써도 괜찮음

    // 정적 리소스 매핑(이미지)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        // localhost:8080/uploads/apple.png 접근 -> c:/chnmwork/uploads/apple.png에 연결
        registry.addResourceHandler("/uploads/**") //**는 /uploads/로 시작하는 모든 요청을 불러옴
                .addResourceLocations("file:" + uploadDir + "/"); //실제 파일이 저장된 위치 // file: 뒤에 빈칸 있으면 안돼
    }

    //전역 CORS 설정 (리액트에서 들어오는 요청을 여기에서 받음)
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/todos/**") // 허용할 API 경로
                .allowedOrigins("http://localhost:5173") // 리액트 개발 서버 주소
                .allowedHeaders("*") // 모든 헤더 허용
                .allowedMethods("*") // 모든 HTTP 메서드 허용
                .allowCredentials(true); // 쿠키, 세션등 인증정보 허용시 필요
    }
}
