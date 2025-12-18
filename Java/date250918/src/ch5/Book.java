package ch5;

//부모 클래스

public class Book {
	
	//필드
	private String title;
	private String author;
	private int price;
	
	

	public Book() {}
	

	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	//getter/setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//메소드
	public void showBook () {
		System.out.println("제목: "+title+", 저자: "+author+", 가격: "+price);

	}

}
