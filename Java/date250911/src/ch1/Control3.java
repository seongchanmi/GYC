package ch1;

import java.util.Scanner;

/*
 * switch문
 * switch (비교값) {
	case value: 
	실행문
	break; // 이 키워드를 만나면 구문을 빠져나감
	
	case value: 
	실행문
	break;
	
	default:
	위의 조건을 모두 만족시키지 못했을 때
	}
 *
 */

/*
 * int day=7;
String yo;

switch (day) {
	case 1: yo="월"; break;
	case 2: yo="화"; break;
	case 3: yo="수"; break;
	case 4: yo="목"; break;
	case 5: yo="금"; break;
	case 6: yo="토"; break; 
	case 0: yo="일"; break; 
	
	default: 
		System.out.println("정해진 숫자만 넣어주세요.");
		return; //main메소드 즉시 종료. 이 다음 코드는 실행되지 않음.
	//default에는 break 안 달아도 됨. 어차피 마지막이라
}

System.out.println("오늘은 " + result + "요일입니다.");	
 */

public class Control3 {
	
	public static void main(String[] args) {

		/*
		 
		int day=7;
		String result= "";
		
		switch (day) {
			case 1: result="월"; break;
			case 2: result="화"; break;
			case 3: result="수"; break;
			case 4: result="목"; break;
			case 5: result="금"; break;
			case 6: result="토"; break; 
			case 0: result="일"; break; 
			
			default: 
				System.out.println("정해진 숫자만 넣어주세요.");
				return; //main메소드 즉시 종료. 이 다음 코드는 실행되지 않음.
			//default에는 break 안 달아도 됨. 어차피 마지막이라
		}
		
		System.out.println("오늘은 " + result + "요일입니다.");	
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요일 숫자를 입력하세요:");
		int day = sc.nextInt();
		String result= "";
		
		switch (day) {
			case 1: result="월"; break;
			case 2: result="화"; break;
			case 3: result="수"; break;
			case 4: result="목"; break;
			case 5: result="금"; break;
			case 6: result="토"; break; 
			case 0: result="일"; break; 
			
			default: 
				System.out.println("정해진 숫자만 넣어주세요.");
		
		
		}
		System.out.println("오늘은 " + result + "요일입니다.");
		//switch문 바깥에 syso를 작성해야 출력이 됨
	
		*/		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요일 숫자를 입력하세요:");
		int day = sc.nextInt();
		String result= "";
		
		if(day>=0 && day <=6 ) {
		
		switch (day) {
			case 1: result="월"; break;
			case 2: result="화"; break;
			case 3: result="수"; break;
			case 4: result="목"; break;
			case 5: result="금"; break;
			case 6: result="토"; break; 
			case 0: result="일"; break; 
			
		}
		System.out.println("오늘은 " + result + "요일입니다.");
		} else {
			System.out.println("정해진 숫자만 넣어주세요.");
		}
		
	}
}
