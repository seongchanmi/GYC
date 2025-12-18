package ch2;


/*
 * 반복문이란?
 * 정해진 횟수만큼 반복
 * 
 * for(초기값; 조건; 증감값) {
 * 실행문
 * }
 * 
 */

import java.util.Scanner;

public class ForEx1 {

	public static void main(String[] args) {
		//1~5까지
		//초기값: 뭐부터 시작할 건지
		//i++: 후위 증가 연산자. ++가 앞에 붙는 것도 있대.
		//i++: 변수 i에 1씩 증가시킨다
		//i--: 1씩감소. 후위 감소 연산자
		for(int i=1; i<=10; i++) {
			System.out.print(++i); //전위증가 "1을 더한 다음에 출력해라"
			System.out.print(i++); //후위증가 "출력한 다음에 1을 더해라"
			System.out.print(i);
		}
		
		
		System.out.println("=========================");
		
		//오하 3번출력
		
		for(int i=0; i<3 ; i++) {
			System.out.print("오하");
		}

		System.out.println("=========================");
		
		// 10부터 1까지 거꾸로 출력
		
		for(int i=10; i>=1; i--) {
			System.out.print(i+","); //println으로 하면 줄바꿈해서 출력해줌
		}
		System.out.println("=========================");
		// 1~10까지 중 홀수만 출력
		
		for(int i=1; i<=10; i++) {
			if(i%2==1) {
				System.out.print(i);
				} 
			}
		
		System.out.println("=========================");
		for(int i=1; i<=10; i+=2) {
			System.out.print(i);
			}
		
		System.out.println("=========================");
		//1부터 10까지의 합
		int sum=0; //담을 그릇이 필요하니까 새로운 변수를 만들어줌

		for(int i=1; i<=10; i++) {
			System.out.println(sum+=i);
			System.out.println(sum);
			System.out.println(i);
			
//			sum += i; 
		} 

		System.out.println(sum);
		
		//for문 안에서는 연산만 하고 출력은 for문 밖에서 해주는 것임
		//이때의 소괄호 안에서 선언해서 i는 지역변수라 괄호 밖에서는 영향을 끼치지 못함. 블럭문 안에서만 사용 가능
		//sum은 괄호 밖에서도 안에서도 사용할 수 있는 전역변수
		
		/*
		 * a+=2 -> a에 2를 더하고 난 값을 다시 a에 재할당
		 * a-=2 -> a에 2를 빼고 난 값을 다시 a에 재할당
		 * a/=2 -> a에 2를 나누고 난 값을 다시 a에 재할당
		 * a*=2 -> a에 2를 곱하고 난 값을 다시 a에 재할당
		 */
		
		System.out.println("=========================");
		
		//1씩 증가해서 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력: ");
		
		int num = sc.nextInt();
				
		for(int i=1; i<=num; i++) {
			System.out.println(i);
		}
		
		System.out.println("=========================");
		//배열 Array: 여러 개의 값을 한 번에 저장할 수 있는 변수
		// length: 배열이나 문자열의 길이(크기, 갯수)를 알려주는 속성
		int[]nums = {3,5,7,9};
		for(int i=0; i<nums.length;i++) {
			System.out.println(nums[i]);
		}
		
		
	}

}
