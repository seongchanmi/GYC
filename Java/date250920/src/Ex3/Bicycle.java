package Ex3;

public class Bicycle implements Vehicle {
	
	private int bicycleSpeed;

	@Override
	public void move() {
		System.out.println("자전거가 움직입니다.");
	}
	
	
	
	public int getBicycleSpeed() {
		return bicycleSpeed;
	}

	public void setBicycleSpeed(int bicycleSpeed) {
		this.bicycleSpeed = bicycleSpeed;
	}

	public void showBicycle () {
		System.out.println("자전거 속도: "+bicycleSpeed);
	}
	
	
	
	
}
