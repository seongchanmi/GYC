package Ex3;

public class BookMain {

	public static void main(String[] args) {

	Book book1 = new Book();
	book1.setTitle("자바의 정석");
	book1.setAuthor("성찬미");
	book1.setPrice(20000);
	
	System.out.println(book1.showInfo());
	
	Textbook book2 = new Textbook();
	book2.setTitle("이것이 자바다");
	book2.setAuthor("신용권");
	book2.setPrice(30000);
	book2.setSubject("IT/자바");
	
	System.out.println(book2.showInfo());
	
	Novel book3 = new Novel();
	book3.setTitle("용의자 x의 헌신");
	book3.setAuthor("히가시노 게이고");
	book3.setPrice(18000);
	book3.setGenre("미스테리");
	
	System.out.println(book3.showInfo());

	



	}
}
