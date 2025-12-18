package ch1;

import java.util.Scanner;

public class Homework_7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요.");
		
		int age = sc.nextInt();
		
		if(age >= 19) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년입니다.");
		}
		 sc.close();
		
		
	}
}
