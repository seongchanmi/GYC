package Ex1;

import java.util.Scanner;

public class Kimbab {

	public static int kimbab (int n) {
		return n*200;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("오늘 삼각김밥 몇 개 드셨어요?");
		
		int n = sc.nextInt();
		int allKimbab = kimbab(n);
		
		System.out.println("김밥으로 섭취한 칼로리는 총 "+allKimbab+"kcal 입니다.");
	}
	
}
