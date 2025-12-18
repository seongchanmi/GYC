package com.example.todos.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

// 로컬에서 파일 저장, 삭제, 파일명 변경 등등 여기서 처리
@Slf4j //log를 사용하기 위한 어노테이션
@Service
public class FileImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    /*
    원본 파일명 가져옴
    UUID-원본 파일명으로 새이름 생성
    로컬 폴더에 저장(transferTo)
    "/uploads/새이름" URL 반환
     */

    // 파일 등록
    public String store(MultipartFile mf){

        if(mf == null || mf.isEmpty()) return null;

        try{
            // 운영체제에 맞는 경로 객체 생성
            Path uploadPath = Paths.get(uploadDir);

            String originalName = mf.getOriginalFilename(); // 원래 파일명을 변수에 저장해줌
            String newName = UUID.randomUUID() + "-" + originalName; //uuid-원래이름  ex) kadfdf386cgf-apple
            Path target = uploadPath.resolve(newName); // 경로 객체에 새로운 이름으로 연결

            // .transferTo() 저장. 한 번 호출 뒤 재호출 안됨
            mf.transferTo(target.toFile()); // 원래 파일 경로는 path형태이나 로컬 저장을 위해 file 형태로 변환

            // 바로 접근 가능한 URL 반환
            return "/uploads/" + newName;

        } catch(Exception e) {
            log.error("오류: " + e.getMessage());
            // throw new RuntimeException("") 500번대 오류
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "파일 저장 실패"); // 400번대 상태 코드로 반환
        }
    }

    // 파일 삭제. "/upload/uuid-원본명" 형태의 URL을 받아 삭제
    public void deleteImage(String imageUrl){

        if(imageUrl == null || imageUrl.isBlank()) return;

        // "/upload/uuid-원본명" -> 파일명만 추출한 것임
        String fileName = imageUrl.replace("/uploads/", "");

        File file = new File (uploadDir + "/" + fileName);

        if(file.exists()){ // 해당 경로에 파일 혹은 폴더가 있으면 true 반환
            boolean result = file.delete(); //삭제
            log.info("이미지 삭제: ", result);
        }

    }

}
