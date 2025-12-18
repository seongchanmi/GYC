package ch1;

import java.util.List;

public class YumService {
	
	private YumDAO dao = new YumDAO();
	

	// 전체 조회
	public List<YumDTO> getAllYum() {
		return dao.selectAllYum();
	}

	// 등록
	public boolean addYum(YumDTO dto) {
		return dao.insertYum(dto);
	}

	// 개별 조회
	public YumDTO getByItem(int id) { //소괄호 안에 있는 변수 이름은 controller에 있는 이름이랑 달라도 상관 ㄴㄴ
		return dao.selectYumById(id);
	}

	public boolean updateYum(YumDTO dto) {
		// dao. updateYum(dto)의 리턴값은 1
		return dao.updateYum(dto) >0 ; // 비교 연산자로 true, false로 호출했던 controller 로 반환
		
	}

	public boolean deleteById(int id) {
		return dao.deleteYum(id) > 0;
	}

	// 전체 맛집 수
	public int getCount() {
		return dao.getAllCount();
	}

	public double getAvgRating() {
		return dao.getAvgRating();
	}

	public int getCountRating(int i) {
		return dao.getCountRating(i);
	}





}
