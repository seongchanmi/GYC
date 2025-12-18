package ch1;

import java.util.Scanner; 

public class Control2 {

	public static void main(String[] args) {
		
		
		
		int temp = 28;
		
		if(temp >= 30 ) System.out.println("덥다");
		else if(temp >= 20) System.out.println("쾌적함");
		else System.out.println("추움");
		
		System.out.println("=====================");
		// 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 나머지는 D
		
		/*int score = 50;
		
		if(score >=90) System.out.println("A");
		else if (score >=80) System.out.println("B");
		else if (score >=70) System.out.println("C");
		else System.out.println("D");
		*/
		
		
		// 91~100점이면 A, 81~90점 이면 B, 71~80점 이상이면 C, 나머지는 D
		/*
		System.out.println("점수를 입력하세요: ");
		int score = ; //선언과 동시에 초기화
		char grade; // 선언만 했음. "grade는 문자열이야~. String은 문장으로 길게 쓸 때. char는 짧은 단어 쓸 때
		
		if(score <=100 && score >=91 ) {
			grade = 'A'; //String grade = 'A';로 적으면 재선언, grade = 'A';는 재할당
		} else if (91> score && score >=81 ) {
			grade = 'B';
		} else if (81> score && score >=71 ) {
			grade = 'C';
		}	else {
			grade = 'D';
		}
		
			System.out.println("점수:" + score + "점, 학점:" + grade);
		
		// 조건에 100>score >=91 이라고 작성했음. 오답임. 오류남.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요:");
		int score = sc.nextInt();
		char grade; 
		
		if(score <=100 && score >=91 ) {
			grade = 'A'; 
		} else if (91> score && score >=81 ) {
			grade = 'B';
		} else if (81> score && score >=71 ) {
			grade = 'C';
		}	else {
			grade = 'D';
		}
		
		System.out.println("입력한 점수는: "+ score + "점 입니다.");
		
	//======================	
	}

}
