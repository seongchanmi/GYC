package day5;

import java.util.List;

//중간 관리자 역할
//구체적인 회원 등록, 조회 구현

public class MemberService {
	

	/*
	 * 의존성 주입
	 * 필요한 객체를 직접 만들지 않고 외부에서 가져와 넣는 것
	 * 외부 DAO 객체를 내부 변수로 저장 (다른 DAO로 교체 가능, Service가 DAO가 필요하다는 것만 알고 내용은 알지 못함)
	 * 
	 */
	
	
	private MemberDAO dao;
	public MemberService(MemberDAO dao) {
		this.dao = dao;
	}


	//회원 등록
	//Controller에서 받음
	public void addMember(String name, String id, String email) {
		MemberDTO dto = new MemberDTO(name,id,email);
		dao.save(dto);
	}
	
	
	//DAO(저장소)에 저장된 회원정보 반환 -> 조회
	//Controller에 반환
	public List<MemberDTO> getAllMember() {
		return dao.findAll(); 
	}
	
	
	
}