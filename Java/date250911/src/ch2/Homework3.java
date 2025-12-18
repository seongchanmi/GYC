package ch2;

import java.util.Scanner;

public class Homework3 {
	//입력 받은 수의 짝수만 출력하는 계산기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력해 주세요");
		
		int a = sc.nextInt();
		/*int b = 2;
		
		while(b<=a) {
			System.out.println(b);
			b+=2;	
		}*/
		
		for(int b=2;b<=a;b+=2) {
			System.out.println(b);
		}

	}

}
