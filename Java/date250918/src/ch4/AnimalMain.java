package ch4;

public class AnimalMain {

	public static void main(String[] args) {
		
		//Animal 인터페이스 타입으로 여러 객체를 담아 똑같은 메서드 호출 가능
		Animal ani1 = new Dog();
		Animal ani2 = new Cat();
		
				
		//메서드
		ani1.sound();
		ani2.sound();
		
	}

}
