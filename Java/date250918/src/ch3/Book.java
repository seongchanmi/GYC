package ch3;

//자식 클래스
public class Book extends Product {
	
	// 필드: 제품명, 가격
	
	String author;
	
	// 생성자
	public Book(String name, int price, String author) {
		super(name, price);
		this.author = author;
	}

	
	// 메서드: 제품명, 가격, 저자 출력
	public void showBook() {
		showInfo();
		System.out.println("저자: " + author);
	}

}
