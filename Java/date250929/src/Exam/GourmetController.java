package Exam;

import java.util.List;
import java.util.Scanner;

public class GourmetController {

	Scanner sc = new Scanner(System.in);

	private GourmetService service;

	public GourmetController(GourmetService service) {
		this.service = service;
	}

	public void run() {

		while (true) {
			System.out.println("번호 입력: 1. 맛집 등록 2. 맛집 조회 3. 개별 맛집 조회 4. 삭제 5. 수정 0. 프로그램 종료");
			int q = sc.nextInt();
			sc.nextLine();

			switch (q) {
			case 1:
				addGourmet();
				break;
			case 2:
				allGourmet();
				break;
			case 3:
				outGourmetById();
				break;
			case 4:
				deleteGourmet();
				break;
			case 5:
				updateGourmet();
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("숫자만 입력하세요");

			}
		}
	}



	private void addGourmet() {
		System.out.println("상호명 입력:");
		String name = sc.nextLine();
		System.out.println("방문일 입력: (예: 2025-09-29)");
		String visitDate = sc.nextLine();
		System.out.println("대표메뉴 입력:");
		String menu = sc.nextLine();
		System.out.println("평점 입력:");
		int rating = sc.nextInt();
		if (rating == 5) {
			System.out.println("인생 맛집! 친구에게 추천!");
		}

		service.saveGourmet(name, visitDate, menu, rating);
		System.out.println("입력완료");
	}

	private void allGourmet() {
		List<GourmetDTO> list = service.getAllGourmet();
		if (list.isEmpty()) {
			System.out.println("등록된 맛집이 없습니다.");
		} else {
			for (GourmetDTO dto : list) {
				System.out.println(dto);
			}
		}

	}
	
	private void outGourmetById() {
		System.out.println("조회할 맛집 입력:");
		String name = sc.nextLine();
		
		GourmetDTO dto = service.getByName(name);
		if(dto == null) {
			System.out.println("등록된 맛집이 없습니다.");
		} else {
			System.out.println(dto);
		}
	}

	private void deleteGourmet() {
		System.out.println("삭제할 맛집 입력: ");
		String name = sc.nextLine();
		if(service.deleteGourmet(name)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("이름이 없습니다.");
		}
		
	}

	private void updateGourmet() {
		System.out.println("수정할 맛집 입력:");
		String name = sc.nextLine();
		
		GourmetDTO dto = service.getByName(name);
		if(dto == null) {
			System.out.println("이름이 없습니다.");
			return;
		}
		System.out.println("변경할 상호명("+dto.getName()+"): ");
		String reName = sc.nextLine();
		System.out.println("변경할 방문일("+dto.getVisitDate()+"): ");
		String reVisitDate = sc.nextLine();
		System.out.println("변경할 대표 메뉴("+dto.getMenu()+"): ");
		String reMenu = sc.nextLine();
		System.out.println("변경할 평점("+dto.getRating()+"): ");
		int reRating = sc.nextInt();
		
		if(service.updateGourmet(name, reName, reVisitDate, reMenu, reRating)) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
	}
}
