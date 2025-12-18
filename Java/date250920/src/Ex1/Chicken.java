package Ex1;

import java.util.Scanner;

public class Chicken {

	public static int chicken(int n) {
		return n*8;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("치킨 몇 마리 주문?");
		
		int n = sc.nextInt();
		int allChicken = chicken(n);
		System.out.println("치킨은 총 "+allChicken+"조각입니다.");
		
		
	}
	
	
}
