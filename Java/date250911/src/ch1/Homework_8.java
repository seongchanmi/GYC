package ch1;

import java.util.Scanner;

public class Homework_8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("오늘 마신 커피 수를 입력하세요.");
		
		int cup = sc.nextInt();
		
		if(cup==0) {
			System.out.println("여긴 어디?");
		} else if(cup>=1 && cup<3) {
			System.out.println("완전 맑은 정신~");
		} else {
			System.out.println("기분 좋은 상태!");
		}
		sc.close();
		
	}
}