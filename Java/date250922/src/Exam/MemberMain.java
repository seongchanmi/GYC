package Exam;

public class MemberMain {

	public static void main(String[] args) {

		Member member1 = new Member();
		member1.setId("chanmi");
		member1.setPassword("abc123");
		member1.setPoint(100);

		System.out.println(member1.toString());
	}

}
