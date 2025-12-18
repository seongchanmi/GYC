package ch1;

//번호, 식자재명, 가격, 수량, 날짜, 생성자, getter/setter, toString

public class FoodDTO {

	private int id;
	private String name;
	private int price;
	private int qty;
	private String date;
	
	public FoodDTO() {}

	public FoodDTO(int id, String name, int price, int qty, String date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.date = date;
	}

	@Override
	public String toString() {
		return "FoodDTO [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + ", date=" + date + "]";
	};
	
	
}
