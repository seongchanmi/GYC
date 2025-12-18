package ch1;

import java.text.DecimalFormat;

/*
 * 1. 품명 입력
 * 2. 전체 조회
 * 3. 개별 조회
 * 4. 삭제
 * 5. 수정
 * 6. 통계
 * 0. 종료
 * 
 * 자동증가번호, 품명, 가격, 주문가능수, 현재 재고(주문 후 남은 수량)
 * 
 */

public class OrderDTO {

	private int id;
	private String name;
	private int price;
	private int limit;
	private int stock;
	private int total;

	public OrderDTO() {
	}

	public OrderDTO(int id, String name, int price, int limit, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.limit = limit;
		this.stock = stock;
		this.total = price * stock;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		setTotal();
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
		setTotal();
	}
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = total;
	}


	DecimalFormat df = new DecimalFormat("#,###");

	@Override
	public String toString() {
		return String.format("번호: %d, 품명: %s, 가격: %s, 주문가능수: %d, 현재재고: %d", id, name, df.format(price), limit, stock);
	}


}
