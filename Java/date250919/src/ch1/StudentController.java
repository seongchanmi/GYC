package ch1;

import java.util.List;
import java.util.Scanner;

//사용자 제어: 입출력
public class StudentController {
	Scanner sc = new Scanner(System.in);
	private StudentService service;
	
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	public void run() {
		while(true) {
			System.out.println("번호 입력: 1. 학생 등록 2. 목록 조회 0. 프로그램 종료");
			int q=sc.nextInt(); // 숫자 입력시 개행문자가 남아있음
			sc.nextLine(); //위에 남은 개행문자를 바로 읽고 버림. 버퍼 정리
			
			switch (q) {
			case 1:
				System.out.println("이름: ");
				String name = sc.nextLine();
				System.out.println("학번: ");
				int num = sc.nextInt();
				sc.nextLine(); //위에 남은 개행문자를 바로 읽고 버림.
				System.out.println("반명: ");
				String classroom = sc.nextLine();
				
				service.addStudent(name, num, classroom);
				System.out.println("학생 등록 끝");
				break;
				
			case 2:
				List<StudentDTO> student = service.getAllStudent();
				
				// 리스트 Student에서 순차적으로 꺼내 dto 타입에 담아 출력
				for(StudentDTO dto : student) {
					System.out.println(dto);
				}
				break;
			case 0:
				System.out.println("프로그램 종료");
			//break; 로 적으면 "구문을 빠져나옴"이고
			return; //return;은 즉시 종료이기 때문에 이 경우엔 return
			default:
				System.out.println("숫자만 입력하세요.");
			}
			
		}
	}

}
