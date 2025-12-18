package ch2;

import java.util.Scanner;

public class Homework6 {

	public static void main(String[] args) {
		//입력한 수로 구구단
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		
		int num = sc.nextInt();
		
		int i = 1;
		
		while(i<=9) {
			System.out.println(num+" X " +i+" = "+(i*num));
			
			i++;
		}
	
		
	}

}
