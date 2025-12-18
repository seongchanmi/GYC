package Exam;

public class GourmetDTO {

	private String name;
	private String visitDate;
	private String menu;
	private int rating;
	
	public void GourmetDTO() {}

	public GourmetDTO(String name, String visitDate, String menu, int rating) {
		this.name = name;
		this.visitDate = visitDate;
		this.menu = menu;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return String.format("상호명: %s, 방문일: %s, 대표메뉴: %s, 평점: %d\n", name, visitDate, menu, rating); 
	}
	

}
