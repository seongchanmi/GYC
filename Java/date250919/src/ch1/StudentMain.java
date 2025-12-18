package ch1;

public class StudentMain {
	
	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		StudentService service = new StudentService(dao);
		StudentController controller = new StudentController(service);
		
		controller.run();
	}

}
