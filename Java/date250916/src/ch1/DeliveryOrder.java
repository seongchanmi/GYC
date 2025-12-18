package ch1;

public class DeliveryOrder {
	String food;
	String address;
		
	public DeliveryOrder(String food, String address) {
		this.food = food;
		this.address = address;
	}

	void deliver() {
		System.out.println("배달 중");
	}
}
