package Ex1;

import java.text.DecimalFormat;

/*
 * 요구사항
 * 1.아이템 번호(자동부여)
 * 2.아이템명
 * 3.수량
 * 4.가격
 * 5.합계
 * 0.프로그램 종료
 * 
 */

public class ItemsDTO {

	private int id;
	private String name;
	private int qty;
	private int price;
	private int total;

	public ItemsDTO() {
	}

	public ItemsDTO(int id, String name, int qty, int price) { //int total을 넣지 않는 이유
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = this.qty * this.price; // 여기서 this.qty * this.price로 바꾸는 이유
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
		setTotal(); // setTotal을 넣는 이유
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		setTotal(); // setTotal을 넣는 이유22
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() { // setTotal(int total)이 아닌 이유 -> 합계값을 내가 계산해서 프로그램에 넣는다는 의미임
		this.total = this.qty * this.price; // 여기서 this.qty * this.price로 바꾸는 이유 222
	}

//	private String formatMoney(int money) { // 작동원리를 잘 모르겠다
//		return String.format("%,s원", money);
//	}
	
	DecimalFormat df = new DecimalFormat("#,###"); //->#,### 3자리 마다 점을 찍어줌

	@Override
	public String toString() {
		return String.format("번호: %d, 이름: %s, 수량: %d, 가격: %s 총합: %s\n",id, name, qty,df.format(price),df.format(total));
	}
	
//	String.format("번호: %d, 이름: %s, 수량: %d, 가격: %s 총합: %s", id, name, qty, formatMoney(price), formatMoney(total));

}
