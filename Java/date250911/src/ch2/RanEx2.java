package ch2;

import java.util.Random;

public class RanEx2 {

	public static void main(String[] args) {
		Random ran = new Random();
		//Random ran1 = new Random(); <- 이런식으로 또하나의 변수를 만들지 않아도 됨
	
		int dice = ran.nextInt(6)+1; //랜덤의 수 시작은 0부터 시작. 그렇기 때문에 +1 해주면 됨
		// next.Int(5); <-괄호 안의 숫자는 "자리수"를 말함
		System.out.println("주사위 랜덤 숫자:" + dice);
		
		String[] fruits = {"사과", "무화과", "포도", "복숭아"}; // 배열
		int idx = ran.nextInt(fruits.length); // 안에 내용을 추가해도 fruits 배열의 길이만큼 알아서 해줌
		System.out.println("오늘의 과일:" + fruits[idx]);
		

	}

}

