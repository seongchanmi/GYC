package hw1;

import java.util.List;
import java.util.Scanner;

public class AnimalController {
	
		Scanner sc = new Scanner(System.in);
		private AnimalService service;
		
		public AnimalController(AnimalService service) {
			this.service = service;
		}
		
		public void run () {
			while(true) {
				System.out.println("번호 입력: 1-회원 등록 / 2-회원 조회 / 0-프로그램 종료");
				int q = sc.nextInt();
				sc.nextLine();
				
				switch (q) {
				case 1:
					System.out.println("아이디: ");
					String id = sc.nextLine();
					System.out.println("보호자명: ");
					String guardian = sc.nextLine();
					System.out.println("반려동물 이름: ");
					String name = sc.nextLine();
					System.out.println("반려동물 나이: ");
					int age = sc.nextInt();
					sc.nextLine();
					System.out.println("연락처: ");
					String phone = sc.nextLine();
					
					service.addAnimal(id, guardian, name, age, phone);
					System.out.println("회원 등록 끝");
					break;
				
				case 2:
					List<AnimalDTO> animal = service.getAllAnimal();
					for(AnimalDTO dto : animal) {
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
