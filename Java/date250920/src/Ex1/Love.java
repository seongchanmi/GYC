package Ex1;

import java.util.Random;
import java.util.Scanner;

public class Love {
	
	public static int love() {
		Random ran = new Random();
		return ran.nextInt(100);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 사람의 이름 입력: ");
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		int per = love();
		System.out.println(a+"와 "+b+"의 연애 성공 확률은 "+per+"%입니다.");
	}

}
