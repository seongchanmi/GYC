package Ex3;

public class Car implements Vehicle {

	private int carSpeed;

	@Override
	public void move() {
		System.out.println("차가 움직입니다.");
	}

	public int getCarSpeed() {
		return carSpeed;
	}

	public void setCarSpeed(int carSpeed) {
		this.carSpeed = carSpeed;
	}

	public void showCar() {
		System.out.println("차 속도: " + carSpeed);
	}

}
