package ch5;

public class PasswordMain {

	public static void main(String[] args) {
		
		Password box = new Password();
		

		box.setPassword("abc123");
		
		System.out.println("내 비밀번호는 " + box.getPassword());

	}

}
