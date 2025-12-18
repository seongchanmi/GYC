package ch1;

//클래스는 설계도!!!!!!!

public class Bread {
	//좋아하는 빵의 객체의 생성자를 만들어 해당 제품명과 금액을 처리한 후 출력
	
	
	// 빵의 특성 만들기!!! ==속성 ==필드
	// private은 접근자가 클래스 내부에서만 접근 가능함
	//  ->필드에 대한 접근은 모두 클래스 내부에서만 가능함
	private String name;
	private int gram;
	private int price;
	private int cnt;
	
	
	// -> 생성자를 통해서 필드에 데이터를 넣어줌
	// 기본생성자 -> 매개변수 없음 	
	public Bread() {} 
	
	//매개변수가 있는 생성자
	Bread (String name, int gram, int price, int cnt){ //마우스 우클릭>>소스>>제네레이트 필드 어쩌고
		this.name = name;
		this.gram = gram;
		this.price = price;
		this.cnt = cnt;
	}
	
	//외부에서의 접근 getter/setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGram() {
		return gram;
	}

	public void setGram(int gram) {
		this.gram = gram;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	// 총 합계 메서드  -> 모르겟삼..>>> 메인메소드에서 처리하는 것을
	
	
	public int breadTotal() { // 매개변수가 없는 경우 
		return this.price * this.cnt;
	}
	
	public int breadTotal(int price) { // 매개변수가 하나 있는 경우 
		return price * this.cnt;
	}
		
	public int breadTotal(int price, int cnt) { // 매개변수가 두개 있는 경우 
		return price * cnt;	
	}
	
	//클래스에서 출력이 된다는 것임

	@Override
	public String toString() {
		return "제품명: " + name + ", 가격: " + price + ", 수량: " + cnt + ", 합계: " + breadTotal();
	}
	
	
	
	
}
