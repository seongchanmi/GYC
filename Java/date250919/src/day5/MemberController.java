package day5;

import java.util.List;
import java.util.Scanner;

//사용자 제어: 입출력
public class MemberController {

	Scanner sc = new Scanner(System.in);
	private MemberService service;
	
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	public void run () {
		 
		while(true) {
			System.out.println("번호 입력: 1-회원 등록 / 2-전체 회원 조회 / 0-종료");
			int q=sc.nextInt(); //  숫자 입력시 개행문자가 남아있음 예)90\n
			sc.nextLine(); // 위에 남은 개행문자를 바로 읽고 버림. 버퍼 정리
			
			
			switch (q) {
			case 1:
				System.out.println("이름: ");
				String name = sc.nextLine();
				System.out.println("아이디: ");
				String id = sc.nextLine();
				System.out.println("이메일: ");
				String email = sc.nextLine();
				
				service.addMember(name, id, email);
				System.out.println("회원 등록 끝");
				break;
			case 2:
				List<MemberDTO> member = service.getAllMember();
				/*
				for(int i=0; i<member.size();i++) {
					MemberDTO dto = member.get(i); // .get() 데이터 가져옴
					System.out.println(dto);
				}
				*/
				
				// 리스트 member에서 순차적으로 꺼내 dto 타입에 담아 출력
				for(MemberDTO dto : member) {
					System.out.println(dto);
				}
				
				break;
			case 0:
				System.out.println("프로그램 종료");
			// break; 구문을 빠져나옴
			return; //즉시 종료
			default:
				System.out.println("숫자만 입력하세요 ");
			}
		}
		
		
	}
	
	
	
	
	
}
