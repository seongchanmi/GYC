package com.example.springboard.dto.response.common;

import com.example.springboard.domain.Member;
import lombok.*;

/*
게시글, 댓글, 회원 페이지 등 작성자 공통 정보
나중에 작성자 정보가 바뀌면 여기만 변경해주면 됨

 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponse {

    private Long id;
    private String nickName;

    // entity -> 작성자 DTO
    public static MemberResponse from(Member member) {
        if(member == null) return null; // 탈퇴 회원 처리

        return MemberResponse.builder()
                .id(member.getId())
                .nickName(member.getNickname())
                .build();
    }

}
