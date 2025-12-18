package Ex3;

public class Textbook extends Book {

	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String showInfo() {
		return super.showInfo()+", 과목: " + subject;
	}
	
	
}
