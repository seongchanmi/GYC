package com.example.springboard.controller;

import com.example.springboard.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/*
  프론트에서 파일 업로드 -> URL 받음
  게시글 작성시 imageUrl 필드에 그 URL을 전달

  HTTP 요청으로 파일 받음 -> fileService.메서드(파일) 호출
  -> 결과를 JSON으로 응답 { "imageUrl" : "경로/파일명.png" }

  controller: 서비스 호출, 응답 리턴
 */
@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;
    // 생성자를 만들지 않아도 final로 상수처리 해주면 @RequiredArgsConstructor가 알아서 생성자 만들어 줌

    // 업로드
    @PostMapping("/image")
    public Map<String, String> uploadImage(@RequestParam("file")MultipartFile file) { // Map<k,v> 순서 없는 리스트, 키와 값을 가짐
        String imageUrl = fileService.saveImage(file); // 파일 검증, 파일명 생성, 경로 생성, 실제 저장, URL 반환
        return Map.of("imageUrl", imageUrl); // imageUrl은 내가 주는 값의 이름
    }

}
