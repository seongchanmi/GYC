package ch1;

/*
 * 변수란?
 * 데이터를 저장하는 그릇
 * 어떤 값이든 저장하고 필요할 때 사용
 * 
 * 자료형(타입)이란?
 * 변수에 담을 값의 타입
 * 숫자, 문자, 참/거짓 등등
 *
 */
public class Basic2 {

	public static void main(String[] args) {
		
		// int 정수
		int age = 20; // (데이터타입) (변수명) = 값;
		int score = -100;
		
		System.out.println(age);
		System.out.println(score);
		
		System.out.println("==========");
		
		// double 실수
		double weight = 48.555;
		
		System.out.println(weight);
		
		System.out.println("==========");
		
		//String 문자열
		String name = "한라봉";
		String phone = "1234-1234";
		
		System.out.println(name);
		System.out.println(phone);
		
		System.out.println("==========");

		//boolean 참&거짓
		boolean isBeauty = true;
		
		System.out.println(isBeauty);
		
		
	}

}
