package com.example.lombokSample.dto;

import lombok.*;

//@Setter // Setter 자동 생성
//@Getter // Getter 자동 생성
@Data // Getter, Setter, toString()... 등도 함께 생성 (스트럭처에서 확인 가능)
@AllArgsConstructor // 매개변수가 있는 생성자를 // public void User(int id, String name) { this.id = id; ...
@NoArgsConstructor // 매개변수가 없는 생성자를 자동으로 만들어줌 //public void User(){}
public class User {

    private int id;
    private String name;


}
