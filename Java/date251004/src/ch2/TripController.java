package ch2;

import java.util.List;
import java.util.Scanner;

public class TripController {
	Scanner sc = new Scanner(System.in);
	private TripService service = new TripService();

	public void run() {

		while (true) {

			System.out.println("계절을 입력하세요 (봄/여름/가을/겨울): ");
			String ans = sc.nextLine();

			List<TripDTO> list = service.getAllTrip(ans);

			if (list.isEmpty()) {
				System.out.println("해당 계절에 평점 4.5점 이상의 추천 여행지가 없습니다.");
			} else {
				System.out.println("\n" + ans + " 추천 여행지 목록 (평점 4.5점 이상)");
				for (TripDTO dto : list) {
					System.out.println(dto);
				}
			}
		}
	}

}
