package ch5;

public class Bicycle implements Vehicle{
	
	private int bicycleSpeed = 20;
	
	public void move() {
		System.out.println("자전거가 움직입니다.");
	}

	public int getBicycleSpeed() {
		return bicycleSpeed;
	}

	public void setBicycleSpeed(int bicycleSpeed) {
		this.bicycleSpeed = bicycleSpeed;
	}
	

	public void showBicycle() {
		System.out.println("자전거 속도: "+bicycleSpeed);
	}

	@Override
	public void showCar() {
		System.out.println("자전거 클래스에 show car");
	} ///이거 왜?????? 이거 없으면 자꾸 에러나는 이유 왜??????



	

	
	
}
