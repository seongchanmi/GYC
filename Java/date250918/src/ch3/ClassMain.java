package ch3;

public class ClassMain {
	//실행 메서드
	public static void main(String[] args) {
		
		//선언
		Parents p1;
		//p1.method1(); 객체(인스턴스) 생성을 하지 않았기 때문에 에러
		
		System.out.println("======Parents======");
		p1 = new Parents();
		p1.method1();
		p1.method2();
		
		System.out.println("======Children======");
		p1 = new Children();
		p1.method1(); //부모메서드1
		p1.method2(); //자식메서드2
		
		System.out.println("======Sister======");
		p1 = new Sister();
		p1.method1();
		p1.method2();
		//p1.method3(); 자식 클래스로부터 유도된 인스턴스는 부모 클래스의 인스턴스가 될 수 없다
		// 마찬가지로 형제 관계에서 유도된 인스턴스도 
		
	}

}
