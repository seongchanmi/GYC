package ch1;

import java.util.Random;
import java.util.Scanner;

public class Homework1 {

	/*01
	 * 치킨 한 마리에 8조각 
	 * public static int chicken(int ord) { 
	 * return ord*8; 
	 * }
	 * 
	 * public static void main(String[] args) { 
	 * Scanner sc = new Scanner(System.in);
	 * System.out.println("치킨 몇 마리 주문?");
	 * 
	 * int ord = sc.nextInt(); 
	 * int allChicken = chicken(ord);
	 * System.out.println("치킨 총 "+allChicken+"조각입니다."); 
	 * }
	 */

	/*02
	 * 커피 1잔에 카페인 80mg
	 * 
	 * public static int caf(int a) { 
	 * return a*80;
	 * }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * Scanner sc = new Scanner(System.in); 
	 * System.out.println("오늘 커피 몇잔?"); 
	 * int a = sc.nextInt();
	 * 
	 * int allCaf = caf(a); 
	 * System.out.println(allCaf); 
	 * }
	 */

	/*03
	 * 삼각김밥 한 개의 칼로리
	 * 
	 * public static int kcal(int num) { 
	 * return num*200; 
	 * }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * Scanner sc = new Scanner(System.in); 
	 * System.out.println("삼각김밥 몇개 먹음?"); 
	 * int num = sc.nextInt(); 
	 * 
	 * int allKcal = kcal(num);
	 * System.out.println("총 "+allKcal+"kcal"); 
	 * }
	 * 
	 */

	/*04
	 * 이름2개 연애 성공확률
	 * 
	 * public static int per() { 
	 * Random ran = new Random(); 
	 * return ran.nextInt(100); 
	 * }
	 * 
	 * public static void main(String[] args) { 
	 * Scanner sc = new Scanner(System.in);
	 * System.out.println("두 사람의 이름 입력: "); 
	 * String a = sc.nextLine(); 
	 * String b = sc.nextLine();	
	 * 
	 * int match = per();
	 * System.out.println(a+"와"+b+"의 연애 성공확률은 "+match+"% 입니다."); 
	 * }
	 */

	/*05
	 * 아무 값도 안 받음. 랜덤으로 추천해주는 메서드
	 * 
	 * public static String randomMenu() { 
	 * Random ran = new Random(); 
	 * int recommend = ran.nextInt(3);
	 * 
	 * String[] meal = {"라면", "김밥", "파스타", "샐러드"}; 
	 * int idx =ran.nextInt(meal.length); 
	 * return meal[idx] ; 
	 * }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("오늘의 밥 추천: " + randomMenu());
	 * 
	 * }
	 */

	/*06
	public static String grade(int score) {
		if (score <= 100 && score > 80) {
			return "A";
		} else if(score <=80 && score>60) {
			return "B";
		} else if (score <=60 && score>40) {
			return "C";
		} else if (score <=40 && score>20) {
			return "D";
		} else {
			return "E";
		}	
	}

		

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		System.out.println(grade(score));
	}
	*/
	
	/*07
	급여 계산
	
	public static int total(int money, int hours) {
		return money * hours;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("시급 입력: ");
		int money = sc.nextInt();
		System.out.println("일한 시간 입력: ");
		int hours = sc.nextInt();
		
		System.out.println("총 급여는 "+total(money, hours)+"원 입니다");

	}
	*/
	
}
