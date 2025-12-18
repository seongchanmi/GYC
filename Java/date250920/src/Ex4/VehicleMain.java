package Ex4;

public class VehicleMain {
	
	public static void main(String[] args) {
		
		Car car1 = new Car();
		car1.move();
		car1.setCarSpeed(40);
		car1.showInfo();
		
		Bicycle bicycle1 = new Bicycle();
		bicycle1.move();
		bicycle1.setBicycleSpeed(20);
		bicycle1.showInfo();
		
	}

}
