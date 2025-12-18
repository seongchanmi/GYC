package hw3;

public class HealthMain {

	public static void main(String[] args) {
	
		HealthDAO dao = new HealthDAO();
		HealthService service = new HealthService(dao);
		HealthController controller = new HealthController(service);
		
		controller.run();

	}

}
