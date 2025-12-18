package hw3;

public class HealthDTO {
	
	private String name;
	private int num;
	private int goal;
	private int result;
	
	public HealthDTO() {}

	public HealthDTO(String name, int num, int goal, int result) {
		this.name = name;
		this.num = num;
		this.goal = goal;
		this.result = result;
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

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "회원명: " + name + ", 회원번호: " + num + ", 기준칼로리: " + goal + ", 소비칼로리" + result;
	}
	
	

}
