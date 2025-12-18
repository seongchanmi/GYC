package hw1;

public class AnimalMain {
	public static void main(String[] args) {
		
		AnimalDAO dao = new AnimalDAO();
		AnimalService service = new AnimalService(dao);
		AnimalController controller = new AnimalController(service);
		
		controller.run();
		
		
	}
}
