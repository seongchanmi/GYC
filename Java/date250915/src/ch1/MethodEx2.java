package ch1;

public class MethodEx2 {
	
	public static int kcal(int a) {
		return a*500;
	}
	public static int pay(int a, int b) {
		return a*b;
	}

	public static void main(String[] args) {
		// 김밥 2개 칼로리 계산 메서드
		System.out.println(kcal(2) + "kcal");
		
		// 지불 금액 계산 메서드
		System.out.println(pay(5000, 2));
	}

}
