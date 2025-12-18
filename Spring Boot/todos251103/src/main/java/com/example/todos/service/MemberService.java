package com.example.todos.service;

import com.example.todos.api.MemberResponse;
import com.example.todos.entity.Member;
import com.example.todos.repository.MemberRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // jakarta.transaction.Transactional 말고 이걸로 import하기
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
서비스 계층
비즈니스 규칙(로직) 담당
@Transactional 경계 설정(변경 감지, 전체 변경을 함께 성공/실패로 처리)
repository로 호출
entity의 메서드 호출해 상태 변경
 */

@Service
@RequiredArgsConstructor // 상수로 선언된 객체는 자동으로 생성자를 만들어 줌. 아래에 주석처리한 this.repo=repo; 이거 작성 안해도 된다는 말임
public class MemberService {
    private final MemberRepository repo;
    /*
    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }
     */

    // 등록
    @Transactional
    public Member register(String name) {
        // name(name) 에서 괄호 안의 name은 입력 받은 변수 String name의 name임
        Member member = Member.builder().name(name).build(); // .builder()로 entity 생성
        //repo에서 save메서드를 가져와 반환
        // JPA가 insert문을 적용
        return repo.save(member);
    }

    // 전체 조회
    @Transactional(readOnly = true) // readOnly = true 수정은 안되고 무조건 읽기만 되는 형태로 변경을 감지
    public List<Member> findAll() {
        return repo.findAll();
    }

    // 개별 조회
    @Transactional(readOnly = true)
    public Member findById(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    // 삭제
    @Transactional
    public void delete(int id) {
        Member member = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(member);
    }

    //수정
    @Transactional
    public void rename(int id, String name) {
        Member member = repo.findById(id).orElseThrow(() -> new  ResponseStatusException((HttpStatus.NOT_FOUND)));
        // 변경 자체가 entity 역할이자 책임.
        member.rename(name);
    }

}
