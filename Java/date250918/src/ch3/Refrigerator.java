package ch3;

public class Refrigerator extends Goods {
	
	public Refrigerator (String brand) {
		super(brand);
	} ////소스에서 constructors from superclass 누르면 자동 생성

	@Override
	public void turnOn() {
		System.out.println("문이 열립니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("문이 닫힙니다.");
	}
}
