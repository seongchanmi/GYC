package ch3;

//자식 클래스
public class Food extends Product{
	// 필드: 제품명, 가격
	String maker;
	
	// 생성자
		public Food(String name, int price, String maker) {
		super(name, price);
		this.maker = maker;
	}

	// 메서드: 제품명, 가격, 생산자 출력

	public void showFood() {
		showInfo();
		System.out.println("생산자: " + maker);
	}
	
}
