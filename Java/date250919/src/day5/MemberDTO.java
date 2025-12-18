package day5;

/*
 * 회원 정보가 들어가는 페이지
 * 
 * 요구사항)
 * 회원 정보: 
 *  아이디, 이름, 이메일
 * 
 * 기능: 
 *  회원 등록(입력)
 *  회원 출력(조회)
 *  프로그램 종료
 *  
 *  회원등록 -> MemberDTO
 * 
 */

public class MemberDTO {
	
	private String name;
	private String id;
	private String email;
	
	public MemberDTO() {}

	public MemberDTO(String name, String id, String email) {
		this.name = name;
		this.id = id;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "이름" + name + ", 아이디=" + id + ", 이메일=" + email;
	}

}
