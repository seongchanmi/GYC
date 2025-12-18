package ch1;

import java.util.Scanner; //자바가 미리 만들어 놓은 기능을 가져다가 쓰는 것. import는 "불러오기"

public class ScannerEx {
	
	public static void main(String[] args) {
		
		
		// 클래스: 설계도. 즉, 붕어빵 틀
		// 객체, 인스턴스: 클래스로부터 실제 사용할 수 있게 만들져 메모리에 존재하는 것
		// 실제로 사용을 하면 인스턴스. 아직 사용하기 전이면 객체
		// 클래스를 사용해서 만든 모든 붕어빵은 객체. 그 붕어빵을 손님이 먹으면 인스턴스.
		// 엄연히 말하면 다르지만 대ㅐㅐ충은 같다 크게 구분하지 않아도 된다
		
		//.nextInt(); 점수 입력 받기
		//.nextDouble(); 실수 입력 받기
		//.nextLine(); 문자열 입력 받기
		
		Scanner sc = new Scanner(System.in); // 클래스로부터 실제로 사용할 수 있게 객체로 만듦.
		//sc는 내가 정한 이름. new라는 키워드를 사용해서 Scanner 메소드를 가져다가 쓴 것. 인스턴스라고 말함
		
		System.out.println("점수를 입력하세요: ");
		int score = sc.nextInt(); //숫자 입력
		System.out.println("입력한 점수는: "+ score + "점 입니다.");
		
	}

}
