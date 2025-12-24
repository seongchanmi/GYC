package com.example.springboard.dto.response.auth;

import com.example.springboard.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/*

로그인 상태 확인용
프론트가 매번 JWT를 파싱하지 않고 현재 로그인한 사용자 정보를 서버 기준으로 확인하기 위해 설정
사람이 읽을 수 있는 정보
JWT에서 사용자 ID를 추출해 DB 조회

- 페이지 새로고침
- 회원정보 페이지
- 게시글 작성자가 본인인지 확인시

 */

@Getter
@AllArgsConstructor
@Builder
public class MyInfoResponse {

    private Long id;
    private String email;
    private String nickname;

    // entity -> DTO
    public static MyInfoResponse from(Member member) {
        return MyInfoResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .build();
    }

}
