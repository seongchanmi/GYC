package ch2;

import java.util.Scanner;

public class Homework4 {
	//두 수를 입력 받아 그 사이 숫자 모두 출력
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 수 입력: ");
		int a = sc.nextInt();
		System.out.println("두 번재 수 입력: ");
		int b = sc.nextInt();
		
			if(a>b) {
				for(int i=b; i<=a; i++) {
					System.out.print(i + " ");
				}

			} else {
				for(int j=a; j<=b; j++)
					System.out.print(j + " ");
			}
			//위의 if가 필요한 이유는 큰수를 먼저 입력할 경우 때문
		
			
				sc.close();
				
	}

}
