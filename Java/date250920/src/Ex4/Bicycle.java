package Ex4;

public class Bicycle {

	private int bicycleSpeed;

	public int getBicycleSpeed() {
		return bicycleSpeed;
	}

	public void setBicycleSpeed(int bicycleSpeed) {
		this.bicycleSpeed = bicycleSpeed;
	}
	
	public void move() {
		System.out.println("자전거가 움직입니다.");
	}
	
	public void showInfo() {
		System.out.println("자전거 속도: "+bicycleSpeed);
	}
}
