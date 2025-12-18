package hw2;

public class FoodMain {
	public static void main(String[] args) {
	
		FoodDAO dao = new FoodDAO();
		FoodService service = new FoodService(dao);
		FoodController controller = new FoodController(service);
		
		controller.run();
		
	}
}
