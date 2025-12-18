package ch1;

import java.util.Scanner;

public class Deposit {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.println("선택> ");

			int button = scanner.nextInt();

			switch (button) {
			case 1:
				System.out.println("입금액을 입력하세요. :");
				int deposit = scanner.nextInt();
				balance += deposit;
//				balance = balance + deposit; 위와 동일 기능
				System.out.println(deposit + "원 입금 되었습니다.");
				break;

			case 2:
				System.out.println("출금액을 입력하세요. :");
				int withdraw = scanner.nextInt();
				if (withdraw > balance) {
					System.out.println("잔고보다 커서 출금할 수 없습니다.");
				} else {
					balance +=withdraw;
//					balance = balance - withdraw; 위와 동일 기능
					System.out.println(withdraw + "원 출금 되었습니다.");
				}
				break;

			case 3:
				System.out.println("잔고: " + balance + "원");
				break;

			case 4:
				run = false;
				break;

			default:
				System.out.println("잘못된 입력입니다.");
				break;

			}
		}
		System.out.println("프로그램 종료");
	}

}
