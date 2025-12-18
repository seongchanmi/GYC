package com.example.todos.api;

/*
요청 받을 때 사용 입력 데이터
DTO 계층
HTTP 통신용으로 Entity를 직접 노출하지 않기 위해 사용
API 전용 객체
 */

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

// 요청하고 응답을 받는 기본 값 작성
// JSON 요청 -> DTO 매핑(객체)
@Getter
public class MemberRequest {

    @NotBlank(message = "이름 필수 작성")
    @Size(max = 50, message = "이름은 최대 50자까지 가능합니다")
    private String name;

}
