package com.example.todos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "todos")
public class Todo {

    @Id
    @SequenceGenerator(
            name = "todos_seq_gen", //JPA에서 사용할 이름
            sequenceName = "todos_seq", //실제 DB 시퀀스 이름
            allocationSize = 1 // 증가 단위
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todos_seq_gen") // 시퀀스 제네레이터의 name과 같은 이름
    private Integer id;

    @Column(nullable = false, length=200)
    private String content;

    //이 둘다 사용은 가능하지만 어노테이션이 달라지고 ??도 달라진다
    //값이 입력될 때 null 입력되어서 호출시 다시 시간을 호출해야 함
   // private LocalDateTime regDate; //DB에서 알아서 작성해주는 시간을 사용하겠다. DB에서 시간 저장.

    @Column(name = "reg_date") // DB와 연결할 이름이 따로 있다는 의미
    @Builder.Default // 필드에 대입한 기본값을 유지하기 위해
    private LocalDateTime regDate = LocalDateTime.now(); //자바에서 가지고 있는 now를 가지고 오는
    //객체를 만들면 자동으로 등록시간이 설정
    // private LocalDateTime regDate; DB에서 시간 저장. 값이 입력될 때 null

    @Column(name = "is_completed", nullable = false, length = 1)
    @Builder.Default
    private YnFlag isCompleted =YnFlag.N; // 사용자가 직접 입력하는 값?
    //내가 이 일을 완료를 했으면, 수정할 수 있게끔?

    /*
    public void uppercase(String isCompleted){
        this.isCompleted = (isCompleted == null) ? "N" : isCompleted.toUpperCase();
    }

    삼항연산자
    조건 ? 참인 경우 : 거짓인 경우
     */

    @Column(name = "image_url")
    private String imageUrl;

    //수정 메서드
    public void updateContent(String txt) { // 새로운 값으로 덮어씌우기?
        this.content = txt;
    }

    public void updateDone(YnFlag ynFlag) {
        this.isCompleted = ynFlag;
    }

    public void updateImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
