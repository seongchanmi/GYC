package com.example.todos.entity;

import jakarta.persistence.*;
import lombok.*;

/*
데이터 모델
DB와 직접 연결
DB와 1:1로 연결
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // DB 테이블과 매핑
@Table(name = "members") // DB 테이블 이름을 명시적으로 연결 (해당 이름의 테이블이 없으면 새로 만들고, 있으면 연결)
public class Member {

    @Id // Primary Key PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값 자동 생성 (자동 증가 컬럼 방식)
    private Integer id;

    // 컬럼 설정 (제약조건, null금지, 문자열 길이 50)
    @Column(nullable = false, length = 50)
    private String name;

    /*
    비즈니스 로직이 들어 있는 도메인 메서드

    setter 함수로 작성하지 않는 이유는 아무나 변경가능하기 때문에
     */
    public void rename(String name) {
        this.name = name;
    }
}
