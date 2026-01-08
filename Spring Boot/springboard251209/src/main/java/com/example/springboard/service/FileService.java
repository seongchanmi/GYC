package com.example.springboard.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${file.upload-dir}") // springframework의 Value값
    private String uploadDir; // 이 값을 사용하면 자동으로 ${file.upload-dir} 이 경로로 치환되어서 사용됨

    // MultipartFile을 받아서 서버에 저장
    public String saveImage(MultipartFile file) {

        // 비어있는지 파일 체크
        if(file == null || file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "업도르 파일이 없습니다");
        }

        // 경로 설정
        try {
            // 운영 객체에 맞는 경로 객체 생성.
            // .toAbsolutePath().normalize(); 절대 경로로 변환
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            log.info("uploadPath = {}", uploadPath);

            // 업로드 폴더가 없는 경우 새로 생성하기
            if(!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
                log.info("업로드 폴더 생성: {}", uploadPath);
            }

            String originalName = file.getOriginalFilename(); // 사용자가 업로드한 파일명을 가져옴
            // 확장자 추출 .png .jpg ...
            String ext = "";
            int idx = originalName.lastIndexOf("."); // 문자열에서 특정 글자가 마지막으로 나온 위치를 찾음. 숫자로 반환
            if(idx != -1) {
                ext = originalName.substring(idx); // idx 위치부터 끝까지 자름
            }

            // String newName = UUID + 기존이름 + 확장자
            String newName = UUID.randomUUID().toString() + ext;

            // 저장
            Path target = uploadPath.resolve(newName); // 폴더 + 파일명을 합쳐서 하나의 경로로 만듦
            // 경로객체 -> 저장을 위한 예전 방식의 파일 객체로 변환
            file.transferTo(target.toFile());

            // 프론트에서 사용할 URL 반환
            return "/image/" + newName;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 업로드 실패",e);
        }
    }

        // 이미지 삭제
    public void deleteImage (String imageUrl) {
        if(imageUrl == null || imageUrl.isBlank()) return;

        // "/image/파일명" -> 파일명 추출
        String fileName = imageUrl.replace("/image/", "");

        // 저장 때와 같이 절대 경로
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        // uplaodpath
        Path target = uploadPath.resolve(fileName).normalize();

        try{
            Files.deleteIfExists(target); // true, false로 반환
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 삭제 중 오류 발생", e);
        }
    }
}
