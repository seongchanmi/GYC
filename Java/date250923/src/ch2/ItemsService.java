package ch2;

import java.util.List;

public class ItemsService {
	
	private ItemsDAO dao;
	int nextId;
	
	public ItemsService(ItemsDAO dao) {
		this.dao = dao;
		this.nextId = getId() +1;
	}
	
	//파일에서 읽어온 데이터의 최대 크기를 id로 사용
	private int getId() {
		int max = 0;
		for(ItemsDTO dto : dao.findAll()) {
			if(dto.getId() > max) {
				max = dto.getId();
			}
		}
		return max;
	}
	
	//상품 등록
	public void saveItems (String name, int qty, int price) {
		ItemsDTO dto = new ItemsDTO(nextId, name, qty, price);
		dao.save(dto);
	}
	
	//전체 상품 조회
	public List<ItemsDTO> getAllItems()	{
		return dao.findAll();
	}

	//아이디로 상품 조회
	public ItemsDTO getById(int id) {
		return dao.findById(id);
	}

	//아이템 삭제
	public boolean deleteItem(int id) {
		return dao.deleteById(id);
	}

	//상품 수정
	public boolean updateItems(int id, String newName, int newQty, int newPrice) {
		return dao.updateDAO(id, newName, newQty, newPrice);
	}

	//합계
	public int getSumTotal() {
		int sum = 0;
		for(ItemsDTO dto : getAllItems()) {
			sum += dto.getTotal();
		}
		return sum;
	}

	//아이템별 수량
	public int getItemsCnt() {
		return dao.count();
	}
	
	
	
}	
