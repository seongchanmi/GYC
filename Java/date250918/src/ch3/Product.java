package ch3;

//부모 클래스
public class Product {

	// 필드: 제품명, 가격
	String name;
	int price;
	
	// 생성자
	//public Product() {}

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// 메서드: 제품명, 가격, 이름 출력
	public void showInfo() { // 이 부분 작성을 못했었슈..
		System.out.println("제품명: " + name + ", 가격: " + price + "원");
	}
	
	
}
