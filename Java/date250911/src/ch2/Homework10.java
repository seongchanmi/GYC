package ch2;

import java.util.Random;

public class Homework10 {
	
	public static void main(String[] args) {
		//주사위를 두 번 던졌을 때, 각각의 결과를 출력
		//두 숫자의 합을 출력

	
		Random rd = new Random();
		
		int dice1 = rd.nextInt(6)+1;
		int dice2 = rd.nextInt(6)+1;
		
		int sum = dice1+dice2;
		
		
		System.out.println("첫 번째 주사위 수: "+dice1);
		System.out.println("두 번째 주사위 수: "+dice2);
		System.out.println("합계: "+sum);
		
				
		
		
	}
}
