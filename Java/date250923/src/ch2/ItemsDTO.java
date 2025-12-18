package ch2;

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
	
	public ItemsDTO() {}

	public ItemsDTO(int id, String name, int qty, int price) {
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = this.qty * this.price;
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
		setTotal();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		setTotal();

	}

	public void setTotal() {
		this.total = this.qty * this.price;
	}

	public int getTotal() {
		return total;
	}
	
	DecimalFormat df = new DecimalFormat("#,###"); 

	@Override
	public String toString() {
		return String.format("번호: %d, 이름: %s, 수량: %d, 가격: %s 총합: %s",id, name, qty, df.format(price),df.format(total));
	}
	
	

}
