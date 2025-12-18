package ch2;

/*
 * 반복문
 * 
 * 초기값
 * while(조건) {
 *  실행문 
 *  증감값
 *  }
 *  
 */
import java.util.Scanner;

public class WhileEx1 {

	public static void main(String[] args) {
		//1~5까지 출력
		int n = 1;
		while(n<=5) {
			System.out.println(n);
			n++; //반드시 증감의 값이 있어야 함
		}
		
		System.out.println("=========================");
		
		//오하 3번 출력
		
		int i = 1;
		while(i<=3) {
			System.out.println("오하");
			i++;
		}
		
		System.out.println("=========================");
		//입력한 숫자만큼 "오하" 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력: ");
		
		int a = sc.nextInt();
		int b = 1;
		while(b<=a) {
			System.out.println("오하");
			b++;
		}
		System.out.println("=========================");
		//2부터 10까지의 짝수 출력
		
		/*int c=2;
		while(c<=10) {
			if(c%2==0) {
				System.out.println(c);
			}
			c++;
		}
		*/
		//위에는 복잡하니까 아래로
		
		int c=2;
		while(c<=10) {
				System.out.println(c);
			c+=2;
		}
		
		//1부터 5까지의 합
		
		
		int sum = 0;
		int d=1;
		
		while(d<=5) {
			sum += d;
			d++;
		} System.out.println("합계:"+sum);
		

	}

}
