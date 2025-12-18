	package Ex1;

import java.util.List;
import java.util.Scanner;

//"번호 입력: 1-아이템 등록 / 2-전체 아이템 조회 / 3-개별 아이템 조회 / 4-아이템 삭제 / 5-아이템 정보 수정 / 6-분석 / 0-종료"

public class ItemsController {

	Scanner sc = new Scanner(System.in);

	private ItemsService service;

	public ItemsController(ItemsService service) {
		this.service = service;
	}

	public void run() {

		while (true) {
			System.out.println("번호 입력: 1-아이템 등록 / 2-전체 아이템 조회 / 3-개별 아이템 조회 / 4-아이템 삭제 / 5-아이템 정보 수정 / 6-분석 / 0-종료");
			int q = sc.nextInt();
			sc.nextLine();

			switch (q) {
			case 1:
				addItem();
				break;
			case 2:
				allItems();
				break;
			case 3:
				outItemById();
				break;
			case 4:
				deleteItem();
				break;
			case 5:
				updateItem();
				break;
			case 6:
				outReport();
				break;
			case 0: System.out.println("프로그램 종료");
				return;
			default: System.out.println("숫자만 입력하세요");
			}
		}
	}

	// 1. 상품 등록
	public void addItem() {
		System.out.println("상품명을 입력하세요");
		String name = sc.nextLine();
		System.out.println("수량을 입력하세요");
		int qty = sc.nextInt();
		System.out.println("가격을 입력하세요");
		int price = sc.nextInt();

		service.saveItem(name, qty, price);
		System.out.println("입력완료");
	}

	// 2. 전체 아이템 조회

	public void allItems() {
		List<ItemsDTO> list = service.getAllItems(); // List<ItemsDTO> 가 어디서 온 건지 명확히 이해가 잘 안됨
		if (list.isEmpty()) {
			System.out.println("등록된 상품이 없습니다.");
		} else {
			for (ItemsDTO dto : list) { // list에 있는 항목들을 처음부터 끝까지 다 하나씩 꺼내서 돌려줌
				System.out.println(dto);
			}
		}
	}

	// 3. 개별 아이템 조회
	private void outItemById() {
		System.out.println("조회할 상품 번호를 입력하세요.");
		int id = sc.nextInt();

		ItemsDTO dto = service.getById(id);
		if (dto == null) {
			System.out.println("번호가 없습니다.");
		} else {
			System.out.println(dto);
		}
	}

	// 4. 아이템 삭제
	private void deleteItem() {
		System.out.println("삭제할 번호를 입력하세요.");
		int id = sc.nextInt();
		if (service.deleteItem(id)) {
			System.out.println("삭제 되었습니다.");
		} else {
			System.out.println("입력 번호가 없습니다.");
		}
	}

	// 5. 아이템 수정
	private void updateItem() {
		System.out.println("수정할 번호를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();

		ItemsDTO dto = service.getById(id); // ItemsDTO dto 왜? 왜 dto인가.. 왜인가....
		if (dto == null) {
			System.out.println("번호가 없습니다.");
			return;
		}
		System.out.println("변경할 상품명(" + dto.getName() + "): ");
		String newName = sc.nextLine();
		System.out.println("변경할 수량(" + dto.getQty() + "): ");
		int newQty = sc.nextInt();
		System.out.println("변경할 가격(" + dto.getPrice() + "): ");
		int newPrice = sc.nextInt();

		if (service.updateItem(id, newName, newQty, newPrice)) {
			System.out.println("수정완료");
		} else {
			System.out.println("수정 실패");
		}
	}

	// 6. 분석
	private void outReport() {
		int sum = service.getSumTotal();
		int cnt = service.getItemCnt();

		String money = String.format("%d원", sum);
		System.out.printf("상품 가격 합계: %s | 상품별 전체 항목: %d개", money, cnt);
		System.out.println();
	}
}
