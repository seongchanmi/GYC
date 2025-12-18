package ch3;

/*
 * 상속
 * 부모 클래스의 속성과 기능을 자식 클래스가 물려받는 것
 * 코드 재사용과 유지보수 용이(부모를 수정하면 자식들도 바뀜)
 * 자식 클래스의 경우 extends 키워드 사용
 * 
 */

public class Parents {

	//속성 == 필드
	int field1;
	String field2;
	
	
	//생성자 
	public Parents() {}
	
	public Parents(int field1, String field2) {
		// super(); 기본 생성자가 있기 때문에 생략 가능
		this.field1 = field1;
		this.field2 = field2;
	}
	
	

	//메서드
	public void method1() {
		System.out.println("부모 메서드1");
	}
	public void method2() {
		System.out.println("부모 메서드2");
	}
	
	
	
}
