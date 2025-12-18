package ch1;

import java.util.Scanner;

public class Homework_2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호를 입력하세요.");
		
		String ans = sc.nextLine();
		
		if(ans.equals("qwer1234")) {
			System.out.println("비밀번호가 맞아요!");
		} else {
			System.out.println("비밀번호가 틀렸어요!");
		}
		
		sc.close();
	}

}
