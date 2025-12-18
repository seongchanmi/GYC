package com.example.todos.controller;

// 페이지에서 진입점

import com.example.todos.api.MemberRequest;
import com.example.todos.api.MemberResponse;
import com.example.todos.entity.Member;
import com.example.todos.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Controller: API 진입점. 외부(브라우저/api tool)과 JPA 사이의 연결 클래스

사용자가 보낸 HTTP 요청(JSON)을 받음
DTD(MemberRequest)로 변환해 Service에 전달
-> 결과를 DTO(MemberResponse)로 만들어 다시 JSON으로 반환

Controller <-> Service <-> Repository <-> Entity <-> DB
 */

@RestController  // Thymeleaf가 없어서 웹뷰가 없기 때문
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    // 등록
    /* Entity를 그대로 반환하기 때문에 권장하지 않음
    @PostMapping
    public Member create(@RequestBody @Valid MemberRequest req) { // 여기에서 Member가 entity임
        return service.register(req.getName()); // JSON 반환
    }

    객체를 그냥 반환. 단순 작업을 할 때 좋음
    헤더 상태나 바디가 고정되어 있기 때문에 다른 작업이 어려움
    @PostMapping //DTO를 거처서 Entity를 접근하는 방식
    public MemberResponse create(@RequestBody @Valid MemberRequest req){
        Member saved = service.register(req.getName()); //이것이 DTO를 거치는 코드
        return MemberResponse.form(saved);
        // MemberResponse 와 MemberRequest가 DTO 임
    }
     */


    /*
    ResponseEntity<DTO> DTO를 감싸는 HTTP 응답 전용 객체
    상태코드, 헤더, 바디를 직접 지정할 수 있어
    COS, 쿠키설정, 헤더 설정이 가능

    반환값: 200, 201 ...
     */

    @PostMapping
    public ResponseEntity<MemberResponse> create(@RequestBody @Valid MemberRequest req){
        Member saved = service.register(req.getName());
        return ResponseEntity.ok(MemberResponse.form(saved));
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<MemberResponse>> memberList(){ //리스트에 담아서 내보내줌. 리스트 형태로 출력하기 위해서
        // DTO 목록으로 대입. 서비스에서 받는 값은 엔티티. 스트림을 통해 변환
        List<MemberResponse> list = service.findAll()
                .stream()
                .map(member -> MemberResponse.form(member))
                .toList(); //스트림을 다시 리스트로 변경. DTO 목록이 된 것임
        return ResponseEntity.ok(list); // body(응답 본문)에 JSON으로 보냄
    }

    // 개별 조회
    @GetMapping("/{id}") // 슬래시가 중괄호 바깥에 있어야 함
    public ResponseEntity<MemberResponse> memberfindById(@PathVariable int id){
        Member member = service.findById(id);
        return ResponseEntity.ok(MemberResponse.form(member));
    }

    // 삭제
    @DeleteMapping("/{id}")
    // ResponseEntity<Void> 응답 body가 없을 때. 수정이나 삭제 후에 돌려받을 값이 따로 없기 때문에 Void
    public ResponseEntity<Void> memberDelete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build(); // 상태코드만 반환 .noContent() -> 204 상태코드
    } // 성공했는지, 실패했는지 상태코드만 보내주면 됨

    // 이름 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> memberRename(@PathVariable int id, @RequestBody @Valid MemberRequest req){
        service.rename(id, req.getName());
        return ResponseEntity.noContent().build();
    }
}
