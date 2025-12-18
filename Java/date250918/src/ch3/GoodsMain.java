package ch3;

/*
 * 추상 클래스 
 * 공통 필드 + 공통 메서드 + 추상 메서드
 * 공통된 속성과 메서드와 특성화(세부) 기능이 있을 때
 */

public class GoodsMain {

	public static void main(String[] args) {

		//Goods goods = new Goods(); 추상 클래스는 객체 생성 x
		Goods phone = new Phone("애플");
	
		phone.showBrand();
		phone.turnOn();
		phone.turnOff();
		
		System.out.println("=== 냉장고 ===");
		
		Goods ref = new Refrigerator("LG");
		
		ref.showBrand(); //일반(공통)메서드는 자식 클래스에서 구현 안해도 ㄱㅊ
		ref.turnOn(); //추상메서드라서 자식클래스(refrigerator)에서 구현해야지 메인에서 불러올 수 있음 
		ref.turnOff();
		
	}

}
