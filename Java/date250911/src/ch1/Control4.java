package ch1;

import java.util.Scanner;

public class Control4 {

	public static void main(String[] args) {
		//1~10까지의 정수 중 하나를 입력 받아 홀/짝수 출력
		
		Scanner sc = new Scanner(System.in); //sc는 변수. 타입은 클래스. 객체.
		System.out.println("1~10까지의 정수 중 하나를 입력하세요.");
	
		int num = sc.nextInt();
		
		/*
		 * int num = 0;
		 * num = sc.nextint();
		 * 
		 * 이렇게 하면 일을 두번 시키는 것임
		 */
		
		if(num< 1 || num >10) {
			if (num % 2 == 0) {
				System.out.println("짝수");
			} else {
				System.out.println("홀수");
		} 
		} else {
			System.out.println("정해진 범위 안의 정수를 입력하세요.");
		}
		
		
		/*
		 *	if(num< 1 || num >10) {
			System.out.println("정해진 범위 안의 정수를 입력하세요.");
		} else if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		 */
		
		sc.close();
		
	}
}
