package ch2;

import java.util.Random;
import java.util.Scanner;

public class Homework11 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		
		int ans = rd.nextInt(50)+1;
		int guess = 0;
		
		while (guess != ans) { 
			//왜 ==가 아니고 !=인지요?!??!
			//괄호 안에 조건문은 "해당 조건이 충족되면 실행문을 실행"의 의미이기 때문에
			//두 수가 같지 않다면 실행문을 실행의 의미가 됨
			System.out.println("1~50까지 중 랜덤 숫자를 맞춰보세요.");
			guess = sc.nextInt();
			
			if(guess < ans) {
				System.out.println("UP");
			} else if (guess > ans) {
				System.out.println("DOWN");
			} else {
				System.out.println("정답");
			}
		}
		sc.close();
		
		
		/*
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		int CorAns = rd.nextInt(50)+1;
		int ans = 0;

		while(ans==CorAns) {
				System.out.println("1~50까지 중 랜덤 숫자를 맞춰보세요.");
				ans = sc.nextInt();
				
				if(ans<CorAns) {
				System.out.println("UP");
			} else if(ans>CorAns) {
				System.out.println("DOWN");
			}
			System.out.println("정답입니다.");
			
			}
		sc.close();
		*/
		
	}

}
