package ch1;

import java.util.List;

//DAO와 Controller의 중간단계
//합계, 자동 증가 번호

public class ProductService {

	private ProductDAO dao;

	public ProductService(ProductDAO dao) {
		this.dao = dao;
	}

	int nextId = 1;

	// 상품 등록
	public void saveProduct(String name, int qty, int price) {
		ProductDTO dto = new ProductDTO(nextId++, name, qty, price);
		dao.save(dto);
	}

	// 전체 상품 조회
	public List<ProductDTO> getAllProduct() {
		return dao.findAll();
	}

	// 삭제
	public boolean deleteProduct(int id) {
		return dao.deleteById(id);
	}

	// 아이디로 상품 조회
	public ProductDTO getById(int id) {
		return dao.findById(id);
	}

	//
	public boolean updateProduct(int id, String newName, int newQty, int newPrice) {
		return dao.updateDAO(id, newName, newQty, newPrice);
	}

	// 상품별 합계 
	public int getSumTotal() {
		int sum = 0;
		for(ProductDTO dto : getAllProduct()) {
			sum += dto.getTotal();
		}	
		return sum;
	}

	//상품별 수량
	public int getProductCnt() {
		return dao.count();
	}

}
