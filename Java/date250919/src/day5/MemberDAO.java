package day5;

import java.util.ArrayList;
import java.util.List;

//회원 리스트 저장, 조회

public class MemberDAO {
	//실제 회원 정보를 추가. 순서있게 저장. 데이터를 담는 컬렉션 객체
	private List<MemberDTO> memberList = new ArrayList<>();
	
	public void save(MemberDTO dto) {
		memberList.add(dto); // 데이터 추가
		
	}// [MemberDTO(한라봉)], [MemberDTO(진지향)], [MemberDTO(타이백)]..
	
	//회원정보 조회(출력)
	public List<MemberDTO> findAll() {
		return memberList;  //저장된 모든 회원 정보를 반환
	}
	
}

/*
 * List
 * 여러 데이터를 순서대로 담을 수 있는 인터페이스
 * 
 * ArrayList
 * 여러 데이터를 순서대로 담을 수 있는 클래스
 * 순서가 있고(인덱스) 자동으로 크기 조절
 * .add(추가) .remove(삭제) .size(데이터 개수)
 * 
 */