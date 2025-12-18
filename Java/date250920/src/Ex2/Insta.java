package Ex2;

public class Insta {

	String account;
	String contents;
	
	Insta (String account, String contents) {
		this.account = account;
		this.contents = contents;
	}
	
	void insta () {
		System.out.println("작성자: "+this.account+", 내용: "+this.contents);
	}
	
}
