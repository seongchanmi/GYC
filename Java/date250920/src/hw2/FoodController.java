package hw2;

import java.util.List;
import java.util.Scanner;

public class FoodController {

	Scanner sc = new Scanner(System.in);
	private FoodService service;
	public FoodController(FoodService service) {
		this.service = service;
		}
	
	public void run () {
		while(true) {
			System.out.println("번호 입력: 1-식자재 등록 / 2-식자재 조회 / 0-프로그램 종료");
			int q = sc.nextInt();
			sc.nextLine();
			
			switch(q) {
			case 1:
				System.out.println("식자재 번호:");
				int num = sc.nextInt();
				sc.nextLine();
				System.out.println("식자재명: ");
				String name = sc.nextLine();
				System.out.println("수량: ");
				int amount = sc.nextInt();
				sc.nextLine();
				System.out.println("등록날짜: ");
				String date = sc.nextLine();
				
				service.addFood(num,name,amount,date);
				System.out.println("식자재 등록 끝");
				break;
				
			case 2:
				List<FoodDTO> food = service.getAllFood();
				for(FoodDTO dto : food ) {
					System.out.println(dto);
					}
				break;
				
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("숫자만 입력하세요");
			}
		}
	}
}
