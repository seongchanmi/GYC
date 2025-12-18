package ch3;

/*
 * 자식 클래스(서브 클래스)
 * class 클래스명 extends 부모 클래스(슈퍼클래스)명 {}
 * 
 */
public class Children extends Parents {
	
	//필드
	double field3;
	
	//생성자
	public Children() {}
	
	public Children (int field1, String field2, double field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		
	}

	//메서드
	@Override
	public void method2() {
		System.out.println("자식 메서드2");
	}
	public void method3() {
		System.out.println("자식 메서드3");
	}
	
}
