package ch1;

//회원 관리
public class User {
	//id, password는 반드시 필요한 필드
	private String id;
	private String password;
	
	//매개 변수가 있는 생성자 (기본 생성자는 안 만들 것임)
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	//메서드
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	
	
}
