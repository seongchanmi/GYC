package day5;

public class MemberMain {

	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		MemberService service = new MemberService(dao);
		MemberController controller = new MemberController(service);
	
		controller.run();
		
		
	}

}
