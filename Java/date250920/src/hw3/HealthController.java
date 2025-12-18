package hw3;

import java.util.List;
import java.util.Scanner;

public class HealthController {
	
	Scanner sc = new Scanner(System.in);
	private HealthService service;
	
	public HealthController(HealthService service) {
		this.service = service;
	}
	
	public void run() {
		
		while(true) {
			System.out.println("번호 입력: 1-회원 등록 / 2-회원 조회 / 0-프로그램 종료");
			int q = sc.nextInt();
			sc.nextLine();
			
			switch(q) {
			case 1:
				System.out.println("회원명: ");
				String name = sc.nextLine();
				System.out.println("회원번호: ");
				int num = sc.nextInt();
				sc.nextLine();
				System.out.println("기준 칼로리: ");
				int goal = sc.nextInt();
				sc.nextLine();
				System.out.println("소비 칼로리: ");
				int result = sc.nextInt();
				sc.nextLine();
				
				service.addHealth(name, num, goal, result);
				System.out.println("회원 등록 끝");
				break;
				
			case 2:
				List<HealthDTO> health = service.getAllHealth();
				
				for(HealthDTO dto : health) {
					System.out.println(dto);
				}
				break;
				
			case 0:
				System.out.println("프로그램 종료");
				return;
				
			default:
				System.out.println("숫자만 입력하세요.");
			}
		}
		
	}

}
