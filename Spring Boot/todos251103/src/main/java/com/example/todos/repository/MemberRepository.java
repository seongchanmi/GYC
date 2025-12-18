package com.example.todos.repository;

/*
데이터 접근 계층(DAO)
Entity를 DB에 저장/조회하는 역할
DB관련 메서드를 직접 구현없이 사용 가능
JpaRepository를 사용하시오

.save(); 저장 insert(update) into members...
.findById(); 아이디로 탐색 select * from members where id =?
.findAll(); 전체 탐색 select * from members
.deleteById(); 삭제 delete from members where id=?
 */

import com.example.todos.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {  }
