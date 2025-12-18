package ch1;

import java.util.List;
import java.util.Scanner;

//사용자 제어 영역
public class ProductController {

	Scanner sc = new Scanner(System.in);
	
	private ProductService service;
	public ProductController(ProductService service) {
		this.service = service;
	}

	public void run() {

		while (true) {
			System.out.println("번호 입력: 1-상품 등록 / 2-전체 상품 조회 / 3-개별 상품 조회 / 4-상품 삭제 / 5-상품 정보 수정 / 6-분석 / 0-종료");
			int q = sc.nextInt();
			sc.nextLine();

			switch (q) {
			case 1: addProduct(); break;
			case 2: allProducts(); break;
			case 3: outProductById(); break;
			case 4: deleteProduct(); break;
			case 5: updateProduct(); break;
			case 6: outReport(); break;
			/*	List<ProductDTO> info = service.getAllProducts();
				int sum = service.getSumTotal();

				if (info.isEmpty()) {
					System.out.println("저장된 상품 정보가 없습니다.");
				} else {
					System.out.println("전체 등록된 상품의 수는 " + info.size() + "명 입니다.");
					System.out.println("전체 등록된 상품의 총 합계 가격은 " + sum + "원입니다.");
					// 상품 가격 총 합!!!!!!!!!!

				
				break; */
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	


	//1. 상품 등록
	private void addProduct() {
		System.out.println("상품명을 입력하세요: ");
		String name = sc.nextLine();
		System.out.println("수량을 입력하세요: ");
		int qty = sc.nextInt();
		System.out.println("가격을 입력하세요: ");
		int price = sc.nextInt();
		
		service.saveProduct(name,qty,price);
		System.out.println("입력 완료");
	}

	//2. 전체 상품 조회
	private void allProducts() {
		List<ProductDTO> list = service.getAllProduct();
		if(list.isEmpty()) {
			System.out.println("등록된 상품이 없습니다.");
		} else {
			for(ProductDTO dto : list) {
				System.out.println(dto);
			}
		}
	}
	
	// 3. 개별 상품 조회
	private void outProductById() {
		System.out.println("조회할 상품 번호를 입력하세요: ");
		int id = sc.nextInt();
		
		ProductDTO dto = service.getById(id);
		if(dto == null) {
			System.out.println("번호가 없습니다.");
		} else {
			System.out.println(dto);
		}
		
	}
	
	// 4. 상품 삭제
	private void deleteProduct() {
		System.out.println("삭제할 번호를 입력하세요: ");
		int id = sc.nextInt();
		if(service.deleteProduct(id)) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("입력한 번호가 없습니다.");
		}
	}
	
	//5. 상품 수정
	private void updateProduct() {
		//수정 번호 입력
		System.out.println("수정할 번호를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		ProductDTO dto = service.getById(id); //dto 혹은 null
		if(dto == null) { //수정 번호가 없으면 번호가 없습니다. 출력
			System.out.println("번호가 없습니다.");
			return; 
		} 
		//수정 번호가 있으면 실행(새로 받을 이름, 수량, 가격 입력)
		System.out.println("변경할 상품명("+dto.getName()+"): ");
		String newName = sc.nextLine();
		System.out.println("변경할 수량("+dto.getQty()+"): ");
		int newQty = sc.nextInt();
		System.out.println("변경할 가격("+dto.getPrice()+"): ");
		int newPrice = sc.nextInt();
		
		//service로 넘겨줌
		if(service.updateProduct(id, newName, newQty, newPrice)) { //true
			System.out.println("수정 완료");
		} else { ///false
			System.out.println("수정 실패");
		}
	}
	
	// 6. 분석: 상품 가격 합계, 상품 수
	private void outReport() {
		int sum = service.getSumTotal();
		int cnt = service.getProductCnt();
		
		String money = String.format("%,d원", sum);
		System.out.printf("상품 가격 합계: %s원 | 상품별 전체 항목 수: %d개", money, cnt);
//		System.out.println("상품 가격 합계: "+sum);
//		System.out.println("상품 전체 수량: "+cnt);
		
	}
}	

	


