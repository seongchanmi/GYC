package ch1;

import java.util.List;
import java.util.Scanner;

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
*/

public class OrderController {

	private OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
	}

	Scanner sc = new Scanner(System.in);

	public void run() {

		while (true) {
			System.out.println("번호 입력: 1-품명 입력 / 2-전체조회 / 3-개별조회 / 4-삭제 / 5-수정 / 6-통계 / 0-종료");
			int q = sc.nextInt();
			sc.nextLine();

			switch (q) {
			case 1:
				addOrder();
				break;
			case 2:
				allOrder();
				break;
			case 3:
				outOrderById();
				break;
			case 4:
				deleteOrder();
				break;
			case 5:
				updateOrder();
				break;
			case 6:
				reportOrder();
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			default: System.out.println("숫자만 입력하세요");

			}
		}

	}
	
	// 1. 품명 입력
		public void addOrder() {
			System.out.println("품명: ");
			String name = sc.nextLine();
			System.out.println("가격: ");
			int price = sc.nextInt();
			System.out.println("주문 가능 수: ");
			int limit = sc.nextInt();
			System.out.println("현재 재고: ");
			int stock = sc.nextInt();

			service.saveOrder(name, price, limit, stock);
			System.out.println("입력 완료");
		}

	//2. 전체 조회
	private void allOrder() {
		List<OrderDTO> list = service.getAllOrder();
		if(list.isEmpty()) {
			System.out.println("등록된 주문이 없습니다.");
		} else {
			for(OrderDTO dto : list) {
				System.out.println(dto);
			}
		}
		
	}


	private void outOrderById() {
		System.out.println("조회할 주문 번호를 입력하세요");
		int id = sc.nextInt();
		
		OrderDTO dto = service.getById(id);
		if(dto == null) {
			System.out.println("번호가 없습니다.");
		} else {
			System.out.println(dto);
		}
	}


	private void deleteOrder() {
		System.out.println("삭제할 번호를 입력하세요");
		int id = sc.nextInt();
		if(service.deleteOrder(id)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("입력 번호가 없음");
		}
		
	}


	private void updateOrder() {
		System.out.println("수정할 번호를 입력하세요");
		int id = sc.nextInt();
		sc.nextLine();
		
		OrderDTO dto = service.getById(id);
		if(dto == null) {
			System.out.println("번호가 없습니다.");
			return;
		} else {
			System.out.println("변경할 상품명("+ dto.getName()+"): ");
			String newName = sc.nextLine();
			System.out.println("변경할 가격("+ dto.getPrice()+"): ");
			int newPrice = sc.nextInt();
			System.out.println("변경할 주문가능수("+ dto.getLimit()+"): ");
			int newLimit = sc.nextInt();
			System.out.println("변경할 현재 재고("+ dto.getStock()+"): ");
			int newStock = sc.nextInt();
			
			if (service.updateOrder(id, newName, newPrice, newLimit, newStock)) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		}
		
	}


	private void reportOrder() {
		int sum = service.getSumTotal();
		int cnt = service.getOrderCnt();
		
		String money = String.format("%d원", sum);
		System.out.printf("전체 재고 합계 가격: %s | 전체 항목 수: %d개", money, cnt);
		System.out.println();
	}


	
}
