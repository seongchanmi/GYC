package Ex1;

import java.util.Scanner;
import java.util.Random;


public class Today3 {

	public static void main(String[] args) {
		
		//치킨 주문 알림기
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("치킨 주문 몇마리");
		int ord = sc.nextInt();
		
		//for문
		for(int i=1;i<=ord; i++) {
			System.out.println("치킨 "+i+"마리 주문이요");
		}
		
		//while문
		int i = 1;
		while (i<=ord) {
			System.out.println("치킨 "+i+"마리 주문이요");
			i++;
		}*/
		
		
		/*스쿼트 계산기
		Scanner sc = new Scanner(System.in);
		System.out.println("스쿼트 몇 번 할까요?");
		int ans = sc.nextInt();
		
		//for문
		for(int i=1; i<=ans; i++) {
			System.out.println("스쿼트 "+i+"회 완료");
		}
		
		//while문
		int i = 1;
		while(i<=ans) {
			System.out.println("스쿼트 "+i+"회 완료");
			i++;
		} */
		
		/*입력받은 수의 짝수만 출력하는 계산기
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력:");
		int ans = sc.nextInt();
		
		//for문
		for(int i=2; i<=ans; i+=2) {
			System.out.print(i);
		}
		
		//while문
		int i=2;
		while(i<=ans) {
			System.out.println(i);
			i+=2;
		}
		*/
		
		/*두 수를 입력 받아 그 사이 숫자 모두 출력
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("첫 번째 숫자");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("두 번째 숫자");
		
		int num1 = sc1.nextInt();
		int num2 = sc2.nextInt();
		
		if(num1>num2) {
			int vacant = num1;
			num1=num2;
			num2=vacant;
		}
		
		//for문
		for(int i=num1; i<=num2; i++) {
			System.out.print(i);
		}
		
		//while문
		int i=num1;
		while(i<=num2) {
			System.out.println(i);
			i++;
		}
		
			sc1.close();
			sc2.close();
			*/
		
		/* 구구단 3단
		int i = 1;
		
		while(i<=9) {
			System.out.println("3 X " +i+" = "+(i*3));
			
			i++;
		}
		*/
		
		/*입력한 수로 구구단 만들기
		
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자 입력: ");
		
		int num = sc.nextInt();
		
		
		for(int i=1; i<=9; i++) {
			System.out.println(num+" X "+i+" = "+num*i);
		}
		
		
		int i=1;
		
		while(i<=9) {
			System.out.println(num+" X "+i+" = "+num*i);
			i++;
		}
		*/
		
		/*숫자를 입력하면, 3의 배수일 때만 점프! || 패스
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력: ");
		
		int ans =sc.nextInt();
		
		if(ans%3==0) {
			System.out.println("점프!");
		} else {
			System.out.println("패스");
		}
		
		*/
		
		/*정수 입력 받아 n*n 정사각형 별 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		
		int ans = sc.nextInt();
		
		for(int i=1; i<=ans; i++) {
			System.out.print("*");
			
			for(int j=1; j<=ans; j++) {
				System.out.print("*");
		}
			System.out.print("\n");
			//System.out.println(); 이렇게 해도 위에랑 같은 결과값을 줌
		}
		*/
		
		
		/*피자 조각 개수와 사람 수를 입력, 한사람당&남는조각
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("피자 조각: ");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("사람 수: ");
		
		int whole = sc1.nextInt();
		int people = sc2.nextInt();
		
		System.out.println("한 사람당 "+ whole/people+"조각 먹을 수 있음");
		System.out.println("남는 조각은 "+whole%people+"조각임");
		
		
		sc1.close();
		sc2.close();
		
		*/
		
		/*주사위를 두 번 던졌을 때, 각각의 결과를 출력하고, 두 숫자의 합을 출력
		
		Random rand = new Random();
		
		int dice1 = rand.nextInt(6)+1;
		int dice2 = rand.nextInt(6)+1;
		
		int sum = dice1+dice2;

		System.out.println("첫 번째 주사위 수: "+dice1);
		System.out.println("두 번째 주사위 수: "+dice2);
		System.out.println("합계: "+sum);
		*/
		
		//1~50 랜덤 숫자, 숫자 맞출때까지 업다운
		
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
				
		int ans = rand.nextInt(50)+1;
		int guess = 0;
		
		while (guess != ans) {

			System.out.println("1~50까지 중 랜덤 숫자를 맞춰보삼");
			guess = sc.nextInt();
			
			//위의 코드를 while문 밖으로 빼면 무한루프에 빠짐
			//이유: 밖으로 빼면 guess 값이 Scanner로 받은 값으로 고정이 되기 때문에
			//while의 조건문이 끊임없이 true이기 때문임
			
			
			if(guess<ans) {
				System.out.println("up!");
			} else if(guess >ans) {
				System.out.println("down!");
			} else {
				System.out.println("정답");
			}
			
			//i++; 이 없어도 괜찮은 이유
			//Scanner로 계속해서 새로운 값을 받기 때문임
			//원래는 i++;가 없으면 계속해서 값이 고정되기 때문에 증감식을 반드시 넣어줘야 함
		}
		sc.close();
		
		
		
	}

}
