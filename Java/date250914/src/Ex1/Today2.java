package Ex1;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Today2 {

	public static void main(String[] args) {
	
		/*비밀번호 맞추기
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호 입력: ");
		String ans = sc.nextLine();
		
		String pw = "qwer1234";
		
		if (ans==pw) {
			System.out.println("비밀번호가 맞아요!");
		} else {
			System.out.println("비밀번호가 틀렸어요!");
			
		} */
		
		/*좋아하는 동물 찾기
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 동물:");
		String ans = sc.nextLine();
		
		//String dog = "강아지";
		//String cat = "고양이";
		
		if (ans.equals("강아지")) {
			System.out.println("멍멍!");
		} else if (ans.equals("고양이")) {
			System.out.println("야옹!");
		} else {
			System.out.println("무슨동물이야?");
		} */
		
		/*주말 맞추기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("무슨 요일일까?");
		int day = sc.nextInt();
		
		if(day==6 || day==0) {
			System.out.println("주말이야");
		} else {
			System.out.println("평일이야");
		} */
		
		/*나이 검사기
		
		Scanner sc = new Scanner (System.in);
		System.out.println("나이 입력: ");
		int age = sc.nextInt();
		
		if (age>=19) {
			System.out.println("성인");
		} else {
			System.out.println("미성년");
		} */
		
		/*카페인
		
		Scanner sc = new Scanner(System.in);
		System.out.println("오늘 마신 커피 수를 입력하세요");
		int cup= sc.nextInt();
		
		if (cup == 0) {
			System.out.println("여긴 어디?");
		} else if (cup>=1 && cup <3) {
			System.out.println("완전 맑은 정신~");
		} else if (cup>=3) {
			System.out.println("기분 좋은 상태!");
		}
		*/
		
		//짝수 홀수 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		
		int num = sc.nextInt();
		
		if(num%2==0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
			
		}
		
		sc.close();

		
	}

}
