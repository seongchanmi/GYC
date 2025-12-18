package ch4;

//구현(implements) 클래스
public class Dog implements Animal{
	//반드시 Animal의 .sound()를 구현해야 함
	public void sound() {
		System.out.println("멍멍");
	}
}
