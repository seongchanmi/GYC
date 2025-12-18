package ch1;


/* 학생 정보가 들어가는 페이지
 * 
 * 이름, 학번, 반명
 * 
 * 학생 등록
 * 목록 조회
 * 프로그램 종료
 * 
 * 학생 등록 -> DTO
 * 
 */

public class StudentDTO {

	private String name;
	private int num;
	private String classroom;
	
	public StudentDTO() {}

	public StudentDTO(String name, int num, String classroom) {
		this.name = name;
		this.num = num;
		this.classroom = classroom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getclassroom() {
		return classroom;
	}

	public void setclassroom(String classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "이름= " + name + ", 학번= " + num + ", 반명= " + classroom;
	}
	
	
	
	
	
}
