package Ex1;

import java.util.Scanner;

public class Coffee {

	public static int coffee(int n) {
		return n*80;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("오늘 커피 총 몇잔 드셨어요?");
		
		int n = sc.nextInt();
		int allCoffee = coffee(n);
		
		System.out.println("하루동안 섭취한 카페인은 총 "+allCoffee+"mg 입니다.");
	}
	
}
