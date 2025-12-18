package ch1;

import java.util.Scanner;

public class Homework_6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("요일을 입력하세요.");
		
		int day =sc.nextInt();
		
		if(day==6 || day==0) {
			System.out.println("주말이야!");
		} else {
			System.out.println("평일이야!");
		}
		sc.close();
	}
}
