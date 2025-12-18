package Ex1;

import java.util.Scanner;

public class Salary {

	public static int salary (int money, int hours) {
		return money*hours;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("시급 입력: ");
		int money = sc.nextInt();
		System.out.println("일한 시간 입력: ");
		int hours = sc.nextInt();
		
		int result = salary(money, hours);
		
		System.out.println("총 급여:" +result+ "원");
		
	}
}
