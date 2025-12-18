package ch3;

//자식 클래스
public class Sister extends Parents {
	//필드
	String field4;
	int field5;
	
	//생성자
	public Sister() {}
	
	public Sister(int field1,String field2, String field4, int field5) { //매개변수에 부모로부터 물려 받은 필드 값 적어줘야 함
		super(field1,field2); 
		//this.field1 = field1; this.field2 = field2; 
		//이렇게 다 써주거나 슈퍼 안에 저렇게 써주거나
		this.field4 = field4;
		this.field5 = field5;
	}
	
	//method2() 자매 메서드 
	@Override
	public void method2() {
		System.out.println("자매 메서드2");
	}
	public void method3() {
		System.out.println("자매 메서드3");
	}
	
}
