package Ex1;

import java.util.List;

public class ItemsService {

	private ItemsDAO dao;

	public ItemsService(ItemsDAO dao) {
		this.dao = dao;
	}

	int nextId = 1;

	// 상품 등록
	public void saveItem(String name, int qty, int price) {
		ItemsDTO dto = new ItemsDTO(nextId++, name, qty, price);
		dao.save(dto);

	}

	// 전체 상품 조회
	public List<ItemsDTO> getAllItems() {
		return dao.findAll();
	}

	// 개별 상품 조회
	public ItemsDTO getById(int id) {
		return dao.findById(id);
	}

	// 아이템 삭제
	public boolean deleteItem(int id) {
		return dao.deleteById(id);
	}

	// 아이템 수정
	public boolean updateItem(int id, String newName, int newQty, int newPrice) {
		return dao.updateDAO(id, newName, newQty, newPrice);
	}

	public int getSumTotal() {
		int sum = 0;
		for (ItemsDTO dto : getAllItems()) {
			sum += dto.getTotal();
		}
		return sum;
	}

	public int getItemCnt() {
		return dao.count();
	}

}
