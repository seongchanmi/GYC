package ch2;

import java.util.Scanner;

public class Homework9 {

	public static void main(String[] args) {
		// 피자 조각 개수와 사람 수를 입력받아,
		// 한 사람당 몇 조각? 남는 조각은 몇개?
		
		Scanner piece = new Scanner(System.in);
		System.out.println("피자 조각 수:");
		Scanner people = new Scanner(System.in);
		System.out.println("사람 수:");
		
		int pc = piece.nextInt();
		int ppl = people.nextInt();
		
		int x = pc/ppl;
		int y = pc%ppl;
		
		System.out.println("한 사람당 "+x+"조각 먹을 수 있음");
		System.out.println("남는 조각은 "+y+"조각임");

	}

}
