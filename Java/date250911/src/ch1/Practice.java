package ch1;

public class Practice {

	public static void main(String[] args) {

		int day=5;
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

		System.out.println("오늘은 " + yo + "요일입니다.");	

	}

}
