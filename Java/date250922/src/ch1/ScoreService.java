package ch1;

import java.util.List;

// 총점, 평균, 학점 계산
// DAO에 저장, 조회 요청하는 비즈니스 로직 영역
public class ScoreService {

	private ScoreDAO dao; // <- 학생 점수 데이터

	// 의존성 주입: 외부에서 DAO 객체를 받아와 내부 변수로 저장. 다른 DAO로 교체 용이.
	public ScoreService(ScoreDAO dao) {
		this.dao = dao;
	}

	// 점수 입력, 계산
	public void addScore(String name, int kor, int eng, int math) { // 입력 받아서 실행한 값은 DTO로 다시 돌려줘야 함

		ScoreDTO dto = new ScoreDTO(name, kor, eng, math);

		int total = kor + eng + math;
		double avg = total / 3.0; // 정수로 넣은 값을 실수로 받고 싶으면 3이 아니라 3.0으로 나눠줘야 함.
		String grade = getGrade(avg);

		dto.setTotal(total); // dto를 통해서 ScoreDTO에 값을 보내줌
		dto.setAvg(avg); // set을 이용해서 초기값 설정
		dto.setGrade(grade);
		
		dao.save(dto); //ScoreList에 학생 한 명의 데이터 추가
		

	}

	private String getGrade(double avg) {

		if (avg >= 90)
			return "A"; // 중괄호 없이 줄바꿈으로 작성하면 안됨. 이 경우엔 짧아서 그냥 한줄로 작성한 것임
		else if (avg >= 80)
			return "B";
		else if (avg >= 70)
			return "C";
		else if (avg >= 60)
			return "D";
		else
			return "F";

	}
	
	// DAO(저장소)에 저장된 모든 학생 점수 정보 리스트 호출
	public List<ScoreDTO> getAllScores() {
		return dao.findAll();
	}

	// 최고 총점
	public int getMaxTotal() {
		
		// 저장된 학생 정보를 리스트로 받아와야 함
		List<ScoreDTO> scores = getAllScores();
		
		if(scores.isEmpty()) return 0; // 데이터가 없는 경우에 0으로 반환
		
		//int min = Integer.MAX_VALUE; int형이 가질 수 있는 가장 큰 값. 2의 31승
		
		//최대값: 최소값부터 시작해서 이전값과 비교해 현재 값이 크면 변수에 재할당
		int max = Integer.MIN_VALUE; //int형이 가질 수 있는 가장 작은 값. -2의 31승
		
		for(ScoreDTO dto : scores)  // <- 배열 안에 있는 값의 개수만큼 반복시켜줌. 배열에 값이 5개 있으면 5번
			if(dto.getTotal() > max) { max = dto.getTotal();
			}
			return max;
		}
	



	public double getAvgTotal() {
		
		List<ScoreDTO> scores = getAllScores();
				
		if(scores.isEmpty()) return 0.0;
		
		// 총점 합/학생수
		int sum = getSumTotal();
		return (double) sum / scores.size(); //강제 형변환: (괄호)치고 타입 입력
		// return sum/3.0; <- 들어갈 수를 알고 있으면 이렇게 작성하면 되지만, 모른다면 위에처럼 입력
	}

	private int getSumTotal() {
		List<ScoreDTO> scores = getAllScores();
		int sum = 0;
		
		for(ScoreDTO dto : scores) {
			sum += dto.getTotal();
		}
		
		return sum;
	}
	
}
