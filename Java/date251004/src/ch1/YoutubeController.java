package ch1;

import java.util.List;
import java.util.Scanner;

public class YoutubeController {

	Scanner sc = new Scanner(System.in);
	private YoutubeService service = new YoutubeService();

	public void run() {
		
		while (true) {
			System.out.println("1. 전체조회 | 0. 종료");
			int q = sc.nextInt();
			sc.nextLine();

			switch (q) {
			case 1:
				allYoutube();
				break;
			case 0:
				System.out.println("프로그램 종료");
				sc.close();
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	private void allYoutube() {
		List<YoutubeDTO> list = service.getAllYoutube();
		outYoutubeList(list);
	}

	private void outYoutubeList(List<YoutubeDTO> list) {
		// null: 객체 자체가 없는 경우, .isEmpty() : 객체는 있으나 데이터가 0
		if (list == null || list.isEmpty()) { // null 체크 후 empty 체크
			System.out.println("맛집 내용 없음");
		} else {
			for (YoutubeDTO dto : list) {
				System.out.println(dto);
			}
		}

	}

}
