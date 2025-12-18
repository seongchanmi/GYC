package ch1;

import java.util.ArrayList;
import java.util.List;

//저장소에서 데이터 처리
public class ProductDAO {

	// 상품 리스트 저장
	private List<ProductDTO> productList = new ArrayList<>();
	// DTO를 기반으로 리스트를 만들걸아~~

	// 상품 등록(추가)
	public void save(ProductDTO dto) {
		productList.add(dto);
	} // add -> 자바가 미리 만들어 놓은 리스트 컬렉션

	// 전체 목록 반환
	public List<ProductDTO> findAll() {
		return productList;
	}

	// 상품 번호로 찾기
	public ProductDTO findById(int id) {
		for(ProductDTO dto : productList) {
			if(dto.getId() == id) {
				return dto;
			}
		}
		return null; // null -> 의도를 가진 없음. 존재하지 않음.
	}

	// 상품 삭제
	public boolean deleteById(int id) {

		//향상된 for문은 조회를 할 때 많이 사용
		  for(ProductDTO dto : productList)
		 
			if(dto.getId() == id) {
				productList.remove(dto); //내부적으로 반복자와 리스트의 크기 달라져 오류 발생할 수 있음
			return true;
		}
		
		
		//삭제시 인덱스 기반, 현재 반복 중인 위치를 직접 관리
		for(int i=0; i<productList.size(); i++) {
			if(productList.get(i).getId() == id) {
				productList.remove(i);
				return true;
			}
		}
		
		return false;
	}

	// 수정은 보통 DTO 객체 자체를 받아서 setter로 처리
	public boolean updateDAO(int id, String newName, int newQty, int newPrice) {
		ProductDTO dto = findById(id);
		if(dto!=null) {
			dto.setName(newName);
			dto.setQty(newQty);
			dto.setPrice(newPrice); //여기까지는 dto에 저장
			
			return true; //수정이 잘 되면 true 반환
		}
		return false;
	}

	public int count() {
		return productList.size();
	}


}
