package ch2;

import java.util.List;
import java.util.Scanner;

public class TripController_2 {

	Scanner sc = new Scanner(System.in);
	private TripService service = new TripService();

	public void run() {

		while (true) {
			
			System.out.println("1. 추천 여행지 조회 | 0. 종료");
			int q = sc.nextInt();
			sc.nextLine();

			switch (q) {
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

	private void getBySeason() {
		System.out.println("계절을 입력하세요. (봄 / 여름 / 가을 / 겨울) \n :");
		String ans = sc.nextLine().trim();
		List<TripDTO> list = service.getAllTrip(ans);
		outTripList(list, ans);
	}

	private void outTripList(List<TripDTO> list, String ans) {
		
		if (list == null || list.isEmpty()) {
			System.out.println("해당 계절에 평점 4.5점 이상의 추천 여행지가 없습니다.");
		} else {
			System.out.println("\n" + ans + " 추천 여행지 목록 (평점 4.5점 이상)");
			for (TripDTO dto : list) {
				System.out.println(dto);
			}
			System.out.println("\n");
		}

	}

}
