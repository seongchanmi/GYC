package com.example.exam251215.dto;

import com.example.exam251215.entity.Todos;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodosDto {

    @NotBlank(message = "내용 작성 필수")
    private String content;

    private Long id;
    private LocalDateTime createdAt;

    public Todos toEntity() {
        return Todos.builder()
                .content(content)
                .build();
    }

    public static TodosDto fromEntity(Todos todos) {
        return TodosDto.builder()
                .id(todos.getId())
                .content(todos.getContent())
                .createdAt(todos.getCreatedAt())
                .build();
    }

}
