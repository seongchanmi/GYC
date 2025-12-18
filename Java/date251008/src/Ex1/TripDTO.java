package Ex1;

public class TripDTO {
	
	private String name;
	private String location;
	private String season;
	private double rating;
	
	public TripDTO() {}

	public TripDTO(String name, String location, String season, double rating) {

		this.name = name;
		this.location = location;
		this.season = season;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return String.format("추천 여행지: %s | 위치: %s | 평점: %.1f",name, location, rating);
	}
	
	

}
