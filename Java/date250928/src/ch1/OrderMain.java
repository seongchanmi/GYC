package ch1;

public class OrderMain {

	public static void main(String[] args) {
	
		String filename = "DB/order.csv";
		OrderDAO dao = new OrderDAO(filename);
		OrderService service = new OrderService(dao);
		OrderController controller = new OrderController(service);
		
		controller.run();

	}

}
