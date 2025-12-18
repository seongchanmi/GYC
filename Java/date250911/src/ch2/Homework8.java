package ch2;

import java.util.Scanner;

public class Homework8 {

	public static void main(String[] args) {
		//정수를 입력 받아, n*n 크키의 네모 별을 출력

		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력:");
		
		int n = sc.nextInt(); //입력받은 값
		int i = 1; //초기값
		
		/*
		 * int i=0;
		 * 으로 할 경우에는 while의 조건에
		 * i<n
		 * j<n
		 * 으로 해줘야 함
		 */
		
		while (i<=n) {
			int j = 1;
			while(j<=n) {
				System.out.print("*");
				j++;
			}
			System.out.println(); //이게 어떻게 줄바꿈인지 이해가 안되는디요.. 띠용
			i++;

		}
		sc.close();
	}

}
