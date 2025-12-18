 package ch2;

public class ItemsMain {

	public static void main(String[] args) {
		
		String filename = "DB/items.csv";
		ItemsDAO dao = new ItemsDAO(filename);
		ItemsService service = new ItemsService(dao);
		ItemsController controller = new ItemsController(service);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	
		controller.run();

	}

}
