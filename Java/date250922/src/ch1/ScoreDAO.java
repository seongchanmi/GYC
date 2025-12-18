package ch1;

import java.util.ArrayList;
import java.util.List;

// 데이터 저장 및 조회. Service에 데이터 제공
public class ScoreDAO {

	// 학생 한 명의 데이터를 받아 List에 추가
	private List<ScoreDTO> scoreList = new ArrayList<ScoreDTO>();

	// 학생 한 명의 정보를 DTO로부터 전달받아 scoreList에 추가
	public void save(ScoreDTO dto) { // 매개변수의 형태로 scoreList에 추가 해줌
		scoreList.add(dto);
	}

	// 저장된 전체 학생 목록(=scoreList)을 호출
	public List<ScoreDTO> findAll() {
		return scoreList;
	} // 호출했던 곳으로 돌려주는 작업
		// findAll의 데이터 형식은 위에 적어준 생성자의 List<SroeDTO>

}
