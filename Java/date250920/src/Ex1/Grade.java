package Ex1;

import java.util.Scanner;

public class Grade {
	
	public static String grade (int score) {
		
		if(100>=score && 80<score) {
			return "A";
		} else if (80>=score && 60<score) {
			return "B";
		} else if (60>=score && 40<score) {
			return "C";
		} else if (40>=score && 20<score) {
			return "D";
		} else if (20>=score && 0<score) {
			return "F";
		} else {
			return "올바른 점수를 입력하세요.";
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		
		int score = sc.nextInt();
		String result = grade(score);
		
		System.out.println(result);
		
	}

}
