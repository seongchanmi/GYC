package Ex3;

public class Book {

	private String title;
	private String author;
	private int price;
	
	public Book() {}
	
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

	
	public String showInfo() {
		return "제목: " + title + ", 저자: " + author + ", 가격: " + price;
	}

		
	
}
