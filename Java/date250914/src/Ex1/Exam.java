package Ex1;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호 입력: ");
		
		String ans = sc.nextLine();
		String result = "";

		
		switch (ans) {
			case "a1234": System.out.println("비밀번호가 맞습니다."); break;
			default:
			System.out.println("비밀번호가 틀렸습니다.");
			} 	


	}
}
