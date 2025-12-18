package ch3;

public class Phone extends Goods {

	public Phone(String brand) {
		super(brand);

	}
	
	
	@Override
	public void turnOn() {
		System.out.println("핸드폰을 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("핸드폰을 끕니다.");
	}
	
}
