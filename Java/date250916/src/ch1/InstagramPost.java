package ch1;

public class InstagramPost {
	
	private String writer;
	private String text;
	
	InstagramPost(String writer, String text) {
		this.writer = writer;
		this.text = text;
		
		
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
