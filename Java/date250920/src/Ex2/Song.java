package Ex2;

public class Song {
	
	String title;
	String artist;
	
	Song (String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	void song () {
		System.out.println(this.artist +"의 " + this.title + "를 보내드립니다.");
	}
	
}
