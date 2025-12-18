   package ch5;

public class TextBook extends Book {
	
	private String subject;

	public TextBook() {}
	
	public TextBook(String title, String author, int price) {
		super(title, author, price);
		this.subject = subject;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void showText() {
		System.out.println("과목명: "+subject);
	}
	
}
