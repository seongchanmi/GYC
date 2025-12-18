package Exam;

public class Music {

	String title;
	String artist;

	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	void music() {
		System.out.println(this.artist + "의 " + this.title + "를 보내드립니다.");
	}

}
