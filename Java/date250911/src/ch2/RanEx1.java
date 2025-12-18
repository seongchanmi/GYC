package ch2;

import java.util.Random;

public class RanEx1 {

	public static void main(String[] args) {

		Random ran = new Random();
		
		int result = ran.nextInt(2); // <- 0,1 중 하나 랜덤
		//.nextInt();는 메서드. 그 안에 들어가는 건 매개변수
		
		if(result==0) {
			System.out.println("동전의 앞면");
		} else {
			System.out.println("동전의 뒷면");
		}
		

	}

}
