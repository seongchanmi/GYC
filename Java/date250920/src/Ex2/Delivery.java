package Ex2;

public class Delivery {
	
	String food;
	String address;
	
	Delivery (String food, String address){
		this.food = food;
		this.address = address;
	}

	void deliver() {
		System.out.println("주문 음식: "+ this.food + ", 배달 장소: " + this.address);
	}
}
