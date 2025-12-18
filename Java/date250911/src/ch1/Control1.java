package ch1;

/*
 * 조건문이란?
 * 조건을 만족시키면 구문 실행
 * ===============================
 * if(조건) {
 * 실행문
 * }
 * ===============================
 * if(조건) {
 * 실행문
 * } else {
 * 실행문
 * }
 * ===============================
 * if(조건) {
 * 실행문
 * } else if(){
 * 실행문
 * } else if(){
 * 실행문
 * } else {
 * 실행문
 * }
 */

public class Control1 {

	public static void main(String[] args) {
		if(5 == 2) {//참이면 아래 구문 실행
			System.out.println("참이면 실행");
		} else if (10<=100) {//else if는 무한히 들어갈 수 있음
			System.out.println("참이면 두 번째 구문 실행");
		}	else {//위의 조건을 모두 만족시키지 못하면 실행
		
			System.out.println("조건을 만족시키지 못하면 실행");
		}
		
		
	}

}
