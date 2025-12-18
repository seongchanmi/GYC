package com.example.todos.api;

/*
응답 보낼 때 사용 출력 데이터
 */

// entity -> JSON 응답

import com.example.todos.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponse {

    private Integer id; //null을 허용하는 Integer
    private String name;

    // 응답 형태를 동일하게 유지하기 위해서 이렇게 작성하기도 함
    public static MemberResponse form(Member member){
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }

}

/*
Builder 패턴
필드 생성자나 옵션의 값이 많은 경우
단계별로 과정과 결과를 분리하는 방법

-필드값이 많을 때
-불변 객체로 사용하고자 할 때
-메서드 체이닝 형식이 필요할 때
-상속엔 잘 사용하지 않음(복잡)

클래스명 객체 = 클래스명.builder()
                  .필드1()
                  .필드2()
                  .필드3()
                  .build();

User user = User.builder()
                .name("한라봉")
                .age(22)
                .build();

 */