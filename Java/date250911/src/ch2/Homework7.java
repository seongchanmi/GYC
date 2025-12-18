package ch2;

import java.util.Scanner;

public class Homework7 {

	public static void main(String[] args) {
		//숫자를 입력하면, 3의 배수일 때만 점프!/패스
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력:");
		
		int i = sc.nextInt();
		
		if(i%3==0) {
			System.out.println("점프!");
		} else {
			System.out.println("패스");
		}

	}

}
