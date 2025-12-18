package ch1;

import java.util.Scanner;

public class Homework_4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 동물을 입력하세요.");
		
		String ans = sc.nextLine();
		
		if("강아지".equals(ans)) {
			System.out.println("멍멍!");
		} else if ("고양이".equals(ans)) {
			System.out.println("야옹!");
		} else {
			System.out.println("무슨 동물이야?");
		}

		sc.close();
		
	}

}
