package ch1;

public class UserMain {

	public static void main(String[] args) {
		
		/*클래스에 기본생성자를 만들지 않았기 때문에 에러 & set 메서드를 만들지 않았기 때문에 에러
		User user = new User();
		user.setId("abc");
		
		회원정보 작성에서 정보가 빠진 채로 객체가 생기는 걸 방지하기 위해 매개변수가 있는 생성자 사용
		*/
		
		User user = new User("abc", "1234");
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		
	}

}
