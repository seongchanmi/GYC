package ch2;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		//=========치킨 주문 알림기=========
		Scanner sc = new Scanner(System.in);
		System.out.println("치킨을 몇 마리 주문하시겠습니까?");

		int ord = sc.nextInt();
		/*int i = 1;

		while (i <= ord) {
			System.out.println("치킨 " + i + "마리 주문이요");
			i++;
		}
		*/
		
		for (int i=1; i<=ord; i++) {
			System.out.println("치킨 "+i+"마리 주문이요");
		}
		

	}

}
