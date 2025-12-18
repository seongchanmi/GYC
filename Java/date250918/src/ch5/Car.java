package ch5;

public class Car implements Vehicle{
	
	private int carSpeed = 80;
	
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
		System.out.println("차 속도: "+carSpeed);
	}

	@Override
	public void showBicycle() {
			System.out.println("자동차 클래스에 show bicycle");
		}///이거 왜?????? 이거 없으면 자꾸 에러나는 이유 왜??????
		
}
