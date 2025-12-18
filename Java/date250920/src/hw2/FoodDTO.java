package hw2;

public class FoodDTO {

	private int num;
	private String name;
	private int amount;
	private String date;
	
	public FoodDTO() {}

	public FoodDTO(int num, String name, int amount, String date) {
		this.num = num;
		this.name = name;
		this.amount = amount;
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "식자재 번호: " + num + ", 식자재명: " + name + ", 수량: " + amount + ", 등록날짜: " + date;
	}
	
	
	
}
