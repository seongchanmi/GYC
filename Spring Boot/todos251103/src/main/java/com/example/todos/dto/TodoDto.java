package com.example.todos.dto;

import com.example.todos.entity.Todo;
import com.example.todos.entity.YnFlag;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private Integer id;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss") // 서버에서 통일된 포맷으로 보낼 때 사용
    private LocalDateTime regDate;
    // 스프링 서버 안에서 제어가 될 때 가져다가 쓰는 필드값
    private YnFlag isCompleted; //  Y / N  의 문자열로 입력값을 받아서 처리
    private String imageUrl;

    // entity 객체 ->  DTO / 요청에서만 들어가는 메서드
    public static TodoDto fromEntity(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .regDate(todo.getRegDate())
                .isCompleted(todo.getIsCompleted())
                .imageUrl(todo.getImageUrl())
                .build();
    }

    // 프론트 요청에서 받은 DTO -> entity 객체 / 응답에서만 들어가는 메서드
    public Todo toEntity(){
        return Todo.builder()
                .id(this.id) // 내용을 변경하지 않을 경우엔 빼고 상관 없음
                .content(this.content)
                .regDate(this.regDate)
                .isCompleted(this.isCompleted != null ? this.isCompleted : YnFlag.N)
                .build();
    }
}

/*
LocalDateTime
시간대(타임존) 없음
연도, 월, 일, 시, 분, 초
여러 날짜 계산 메서드 제공
DateTimeFormatter() 포맷 사용
불변성 가짐
 */