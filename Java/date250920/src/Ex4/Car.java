package Ex4;

public class Car {
	
	private int carSpeed;

	public int getCarSpeed() {
		return carSpeed;
	}
	
	public void setCarSpeed(int carSpeed) {
		this.carSpeed = carSpeed;
	}
	
	public void move() {
		System.out.println("차가 움직입니다.");
	}
		
	public void showInfo() {
		System.out.println("차 속도: "+carSpeed);
	}
	
	

}
