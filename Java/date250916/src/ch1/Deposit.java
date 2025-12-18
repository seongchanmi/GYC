package ch1;

import java.util.Scanner;

public class Deposit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true; //여기의 run 은 public static void main(String[] args) {} 안의 전범위에 영향
		int num = 0;//입력 번호
		int money = 0;  //입금, 출금
		int balance = 0; //잔고
		//입력받은 금액을 while, switch 전체에서 사용하기 때문에 바깥에 적어줌

		
		while(run) {
			System.out.println("-----------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-----------------------------------");
            System.out.println("선택> ");
            num = sc.nextInt(); // 입력값 받는 해당 코드를 while 밖에 적으면 입력값을 한 번 밖에 안 받음
            //입력값을 계속해서 받아줘야 하기 때문에 while문 안에 적어줌
            
            switch (num) {
            
				case 1: // 예금 
					System.out.println("입금액: ");
					money = sc.nextInt();
					if(money>0)	{						
						balance += money; // balance = balance + money;
						System.out.println(money +"원 입금되었습니다.");
					} else {
						System.out.println("원 입금되지 않았습니다.");
					}
					break; // 이 키워드를 만나면 더이상 진행하지 않고 구문을 빠져나옴	
					
				case 2: // 출금
					System.out.println("출금액: ");
					money = sc.nextInt();
					if(money <= balance) {
						balance -= money;
						System.out.println(money+"원 출금 되었습니다");
					} else {
						System.out.println(money+"원 출금되지 않았습니다");
					}
					break;
					
				case 3: // 잔고 
					System.out.println("잔고: "+balance);
					break;
					
				case 4: // 종료 
					run = false; //재할당
					break;
					
				default:

			}
			
		}
		
		System.out.println("프로그램 종료");

	}

}
