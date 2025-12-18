package ch2;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("스쿼트 몇 번 할까요?");
		
		int i = sc.nextInt();
	/*	int n = 1;
		
		while(n<=i) {
			System.out.println("스쿼트 "+n+"회 완료");
			n++;
			
		} System.out.println("오늘 운동 끝");
*/
		
		for (int n=1; n<=i; n++) {
			System.out.println("스쿼트 "+n+"회 완료");
		}
		System.out.println("오늘 운동 끝");
		
	}

}
