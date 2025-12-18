package ch1;

/*
 * 상품 관리 프로그램
 * 1. 상품 등록: 상품명, 수량, 가격, 상품번호(자동생성,자동증가)
 * 2. 전체 상품 조회: 상품번호, 상품명, 수량, 가격, 합계 출력
 * 3. 개별 상품 조회: 원하는 상품 번호 입력시 해당 상품만 조회
 * 4. 상품 삭제: 삭제할 상품 번호 입력시 해당 상품 삭제
 * 5. 상품 정보 수정: 수정할 상품 번호 입력시 해당 상품 정보 수정
 * 6. 분석: 전체 상품의 수, 전체 상품 가격의 합
 * 0. 프로그램 종료
 * 
 */

public class ProductDTO {

	private int id; // 상품 번호 (자동 증가)
	private String name;
	private int qty;
	private int price;
	private int total; // 합계 = qty * price;

	public ProductDTO() {}

	public ProductDTO(int id, String name, int qty, int price) {
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
		setTotal(); // qty, price가 변경되면 자동갱신
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		setTotal(); // qty, price가 변경되면 자동갱신
	}

	// 수량과 가격이 변동되면 합계도 자동 계산
	private void setTotal() {
		this.total = this.qty * this.price;
	}

	public int getTotal() {
		return total;
	}
	
	/*
	 * %.2f
	 * %d
	 * 
	 * %,d 정수의 3자리마다 쉼표(,) 표기
	 * 
	 */
	
	private String formatMoney(int money) {
		return String.format("%,d원", money);
	}

	@Override
	public String toString() {
		return String.format("번호:%d, 상품명:%s, 수량:%d, 가격:%s, 합계:%s", id, name, qty, formatMoney(price), formatMoney(total));
	}

}
