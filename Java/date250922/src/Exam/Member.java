package Exam;

public class Member {

	private String id;
	private String password;
	private int point;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "아이디: [" + id + "], 포인트: [" + point + "]점";
	}

}
