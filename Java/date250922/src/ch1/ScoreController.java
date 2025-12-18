package ch1;

import java.util.List;
import java.util.Scanner;

public class ScoreController {

	private ScoreService service;
	Scanner sc = new Scanner(System.in);

	public ScoreController(ScoreService service) {
		this.service = service;
	}
	// ^^^^ Service에서 필요한 값을 가져옴

	public void run() {

		while (true) {
			System.out.println("번호 입력: 1-점수 입력 / 2-조회 / 3-학생수 / 4-분석 / 0-종료");
			int q = sc.nextInt();
			sc.nextLine(); // 버퍼 정리

			switch (q) {
			case 1:
				System.out.println("이름: ");
				String name = sc.nextLine();
				System.out.println("국어: ");
				int kor = sc.nextInt();
				System.out.println("영어: ");
				int eng = sc.nextInt();
				System.out.println("수학: ");
				int math = sc.nextInt();
				//sc.nextLine();
				
				service.addScore(name, kor, eng, math);
				System.out.println("입력 완료");
				break;

			case 2:
				List<ScoreDTO> scores = service.getAllScores();
				
				//for문, 인덱스값을 이용해서 값을 불러옴
				// 리스트 값이 늘어났다 줄었다 할 수 있기 때문에 scores.size()를 사용
				// 인덱스 값은 항상 하나가 많기 때문에 1보다 같지 않고(<=), 1보다 커야 함
				/*
				for(int i=0;i<scores.size();i++) { 
					ScoreDTO dto = scores.get(i);
					System.out.println(dto);
				}
				*/
				if(scores.isEmpty()) {// List의 score 객체의 값이 비어있으면 true 반환
					System.out.println("저장된 학생 점수가 없습니다.");
				} else {
				
				for(ScoreDTO dto : scores) { // 모든 학생 점수 리스트가 저장된 scores에서 순차적으로 꺼내 dto에 담아 출력
					System.out.println(dto);					
					}
				}
				break;

			case 3:
				//List<ScoreDTO> score = service.getAllScores();
				//System.out.println("전체 등록된 학생의 수는 "+score.size()+"명 입니다.");
				
				int out = service.getAllScores().size(); // 더 제어할 게 없고 출력만 한다고 하면 변수에 넣어서
				System.out.println("전체 등록된 학생의 수는 "+out+"명 입니다.");
				break;

			case 4:
				List<ScoreDTO> info = service.getAllScores();
				if(info.isEmpty()) {
					System.out.println("저장된 학생 정보가 없습니다.");
				} else {
					
					// 최고 총점
					int max = service.getMaxTotal();
					System.out.println("최고 총점: "+max);
					
					// 최저 총점
					
					
					// 총점 평균
					double avg = service.getAvgTotal();
					System.out.printf("총점 평균: %.2f\n", avg);// println 말고 printf로. %.2f <-실수이기 때문에 f를 적어줌
					
				}
				
				break;

			case 0:
				System.out.println("프로그램 종료");
				return; // 반드시 return으로~

			default:
				System.out.println("숫자만 입력해 주세요.");
			}
		}
	}

}
