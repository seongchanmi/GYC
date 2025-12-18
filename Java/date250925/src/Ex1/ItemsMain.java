package Ex1;

public class ItemsMain {

	public static void main(String[] args) {

		ItemsDAO dao = new ItemsDAO();
		ItemsService service = new ItemsService(dao);
		ItemsController controller = new ItemsController(service);
		controller.run();
	}
}
