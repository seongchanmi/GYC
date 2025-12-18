package ch5;

public class BookMain {

	public static void main(String[] args) {
		
		Book book = new Book();
		book.setTitle("자바의 정석");
		book.setAuthor("성찬미");
		book.setPrice(20000);
		
		
		TextBook tb = new TextBook();
		tb.setTitle("이것이 자바다");
		tb.setAuthor("신용권");
		tb.setPrice(30000);
		tb.setSubject("IT/자바");
		
		Novel nv = new Novel();
		nv.setTitle("용의자 x의 헌신");
		nv.setAuthor("히가시노 게이고");
		nv.setPrice(18000);
		nv.setGenre("미스테리");
		
		System.out.println("====Book====");
		book.showBook();
		
		System.out.println("====TextBook====");
		tb.showBook();
		tb.showText();
		
		System.out.println("====Novel====");
		nv.showBook();
		nv.showNovel();
		
	
	}
}
