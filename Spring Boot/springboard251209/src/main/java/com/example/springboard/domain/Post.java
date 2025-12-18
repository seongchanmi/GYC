package com.example.springboard.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="post_id")
    private Long id;

    // private Member member; // 회원가입만 한사람만 글을 쓸 수 있게 한다던지와 같이 로그인과 회원과 관련된 속성

    // 제목, 필수 작성
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    // 작성글. 대용량 글(@Lob)
    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    // 첨부 이미지로 DB에 경로만 저장
    @Column(name = "image_url", length = 500)
    private String imageUrl;

    // 조회수
    @Column(name = "read_count", nullable = false)
    private Integer readCount; // 숫자 0도 허용하고 싶어서 Integer 사용

    // 작성일
    @CreationTimestamp // 인서트가 실행이 될 때마다 현재 시간이 알아서 주입해줌
    @Column(name = "created_at", nullable = false, updatable = false) // updatable = false 이 이후에 수정이 이루어져도 내용을 수정시키지 않음
    private LocalDateTime createdAt;

    // 수정일
    @UpdateTimestamp // 업데이트 구문이 실행이 될 때마다 현재 시간이 알아서 주입이 됨
    @Column(name = "updated_at") // 수정이 없으면 값이 없을 수 있기 때문에, null이 가능함
    private LocalDateTime updatedAt;

    /*
    @PrePersist     :   insert 전
    @PostPersist    :   insert 후
    @PreUpdate      :   update 전
    @PostLoad       :   엔티티가 DB에서 조회된 직후
    */

    @PrePersist
    public void prePersist() {
        if(readCount == null) readCount= 0;
    }
     // 조회수 증가 메서드
    public void increaseReadCount() {
        this.readCount++;
    }

    // 수정 업데이트 메서드
    public void update (String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

}
