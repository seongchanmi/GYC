package Ex3;

public class VehicleMain {

	public static void main(String[] args) {

		Car car1 = new Car();
		car1.move();
		car1.setCarSpeed(50);
		car1.showCar();

		Bicycle bicycle1 = new Bicycle();
		bicycle1.move();
		bicycle1.setBicycleSpeed(20);
		bicycle1.showBicycle();

	}

}
