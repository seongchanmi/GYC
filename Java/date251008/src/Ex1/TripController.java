package Ex1;

import java.util.List;
import java.util.Scanner;

public class TripController {
	
	Scanner sc = new Scanner(System.in);
	private TripService service = new TripService();

	public void run() {

		while (true) {
			System.out.println("1. 추천 여행지 조회 | 0. 종료");
			int q = sc.nextInt();
			sc.nextLine();
			
			switch(q) {
			case 1: 
				getBySeason();
				break;
			case 0: 
				System.out.println("프로그램 종료");
				sc.close();
				return;
			default:
				System.out.println("잘못된 입력");
			}
			
		}
		
	}

	private void getBySeason() { // 데이터를 불러오는 역할
		System.out.println("계절을 입력하세요.\n봄 | 여름 | 가을 | 겨울");
		String ans = sc.nextLine().trim();
		List<TripDTO> list = service.getAllTrip(ans); // 이 구문의 정확한 뜻을 알고 싶음
		outTripList(list, ans);
	}

	private void outTripList(List<TripDTO> list, String ans) { // 불러온 데이터를 출력하는 역할
		if(list == null || list.isEmpty()) {
			System.out.println("해당 계절에 평점 4.5점 이상의 추천 여행지가 없습니다. ");
		} else {
			System.out.println("\n"+ ans + " 추천 여행지 목록 ~평점 4.5점 이상~ ");
			for(TripDTO dto : list) {
				System.out.println(dto);
			}
			System.out.println("\n");
		}
	
	}

}
