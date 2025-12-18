package Ex3;

public class Novel extends Book {

	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String showInfo() {
		return super.showInfo() + ", 장르: " + genre;
	}

}
