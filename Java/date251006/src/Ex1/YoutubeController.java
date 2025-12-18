package Ex1;

import java.util.List;
import java.util.Scanner;

public class YoutubeController {
	
	private YoutubeService service = new YoutubeService();
	Scanner sc = new Scanner(System.in);
			
	public void run() {
		
		while (true) {
			System.out.println("1. 전체 조회 | 0. 종료");
			int q = sc.nextInt();
			sc.nextLine();
			
			switch(q) {
			case 1: 
				allYoutube();
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
	// 데이터를 불러옴
	private void allYoutube() {
		List<YoutubeDTO> list = service.getAllYoutube();
		outYoutubeList(list);
	}
	
	// 데이터를 출력함
	private void outYoutubeList(List<YoutubeDTO> list) {
		if(list == null || list.isEmpty()) {
			System.out.println("등록된 영상 정보 없음");
		} else {
			for(YoutubeDTO dto : list) {
				System.out.println(dto);
			}
		}
		
	}
	
}
