package ch5;

public class VehicleMain {

	public static void main(String[] args) {
	Vehicle car1 = new Car();
	Vehicle bicycle1 = new Bicycle();
	
	car1.move();
	bicycle1.move();
	
	car1.showCar();
	bicycle1.showBicycle();
	}

}
