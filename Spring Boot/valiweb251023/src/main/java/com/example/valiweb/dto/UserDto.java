package com.example.valiweb.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "이름은 필수입니다.")
    @Size(max = 5, message = "이름은 5자 이내로 작성하세요")
    private String name;

    @Min(value = 1, message = "나이는 1세이상 작성해야 합니다") // message는 생략 할 수 있음
    @Max(value = 20, message = "나이는 50세 이하만 가능합니다.")
    private Integer age;

    /*
    ? : 있을수도 있고 없을 수도 있다
    "^(0\\d{2,3})-?\\d{3,4}->\\d{4}$"
    ^ 문자열 시작
    $ 문자열 끝
    \\d 숫자
    {1,3} 1~3자리 숫자
    {4} 4자리 숫자

    "^(01[0-9])-?[0-9]{3,4}-?[0-9]{4}$"
     */
    @NotBlank(message = "연락처는 필수입니다.")
    @Pattern(
            regexp = "^(0\\d{1,2})-?\\d{3,4}-?\\d{4}$",
            message = "010-1234-5678 혹은 01012345678 작성해주세요"
    )
    private String phone;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 바르지 않습니다")
    private String email;

    @NotBlank(message = "주소는 필수입니다.")
    @Size(max = 100, message = "주소는 100자 이내로 입력하세요")
    private String address;
}
