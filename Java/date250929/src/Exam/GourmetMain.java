package Exam;

public class GourmetMain {

	public static void main(String[] args) {

		GourmetDAO dao = new GourmetDAO();
		GourmetService service = new GourmetService(dao);
		GourmetController controller = new GourmetController(service);
		controller.run();

	}

}
