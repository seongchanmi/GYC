package ch5;

public class Novel extends Book {

	private String genre;

	public Novel() {}
	
	public Novel(String title, String author, int price) {
		super(title, author, price);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void showNovel () {
		System.out.println("장르: " + genre);
	}
	
	
}
