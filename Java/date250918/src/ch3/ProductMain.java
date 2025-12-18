package ch3;

public class ProductMain {

	public static void main(String[] args) {
		// 매개변수가 있는 생성자를 통해 제품명, 가격, 저자 혹은 생산자를 입력
		
		Product pd1;
		
		System.out.println("=====Product=====");
		pd1 =new Product("자바의 정석",25000); //바로 입력할 데이터가 있으면 빈 생성자가 없어도 작업 가능
		//pd1 = new Product(); 이렇게 작성하고 싶을 경우엔 클래스에 빈 생성자가 있어야함
		pd1.showInfo();
				
		System.out.println("=====Book=====");
		Book book = new Book("자바란 무엇인가?",20000,"자바");
		book.showBook();
	
		System.out.println("=====Food=====");
		Food food = new Food("감귤",15000,"한라봉");
		food.showFood();
		
	}

}
