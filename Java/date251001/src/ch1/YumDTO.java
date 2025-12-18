package ch1;

import java.sql.Date;

public class YumDTO {

	private int id; //번호 pk
	private String name; //상호
	private Date visitDate; //방문일 yyyy-MM-dd
	private String menu; //메뉴
	private int rating; //평점
	private Date regDate; //작성날짜 yyyy-MM-dd hh:mm:ss
	
	public YumDTO() {}
	
	
	//DB에 입력할 때 필요한 생성자
	public YumDTO(String name, Date visitDate, String menu, int rating) {
		this.name = name;
		this.visitDate = visitDate;
		this.menu = menu;
		this.rating = rating;
	}


	//DB로부터 읽어올 때 필요한 생성자
	public YumDTO(int id, String name, Date visitDate, String menu, int rating, Date regDate) {
		this.id = id;
		this.name = name;
		this.visitDate = visitDate;
		this.menu = menu;
		this.rating = rating;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return String.format("%d번 %s | 방문일: %s | 메뉴: %s | 평점 %d점 | 작성일: %s", id, name, visitDate, menu, rating, regDate);
	}
	
	
}
