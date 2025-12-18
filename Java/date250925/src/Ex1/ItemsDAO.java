package Ex1;

import java.util.ArrayList;
import java.util.List;

public class ItemsDAO {

	// 상품 리스트 저장소
	private List<ItemsDTO> itemsList = new ArrayList<>();

	// 상품 등록(추가)
	public void save(ItemsDTO dto) {
		itemsList.add(dto);
	}

	// 전체 목록 반환
	public List<ItemsDTO> findAll() {
		return itemsList;
	}

	// 개별 아이템 반환
	public ItemsDTO findById(int id) {
		for (ItemsDTO dto : itemsList) {
			if (dto.getId() == id) {
				return dto;
			}
		}
		return null;
	}

	public boolean deleteById(int id) {
		// for문, 인덱스 기반, 현재 반복 중인 위치를 직접 관리
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getId() == id) {
				itemsList.remove(i);
				return true;
			}
		}
		return false;
	}

	// 수정은 보통 DTO 객체 자체를 받아서 setter로 처리 -> 이게 무슨 말?????
	public boolean updateDAO(int id, String newName, int newQty, int newPrice) {
		ItemsDTO dto = findById(id);
		if (dto != null) {
			dto.setName(newName);
			dto.setQty(newQty);
			dto.setPrice(newPrice);
			return true;
		}
		return false;
	}

	public int count() {
		return itemsList.size();
	}

}
