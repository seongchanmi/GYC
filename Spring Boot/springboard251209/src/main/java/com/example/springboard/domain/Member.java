package com.example.springboard.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "member",
uniqueConstraints = {@UniqueConstraint(columnNames = "emails")}) // email은 중복되지 않음
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    // 로그인 ID
    @Column(name = "email", nullable = false, length = 255)
    private String email; // 로그인 id

    // 암호화된 비밀번호
    @Column(nullable = false, length = 255)
    private String password;

    // 게시판에 표시되는 이름
    @Column(nullable = false, length = 50)
    private String nickname;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // 닉네임 변경 메서드
    public void changeNickname(String nickname) {
        this.nickname=nickname;
    }

    public void changePassword(String encodePassword) {
        this.password=encodePassword;
    }
}
