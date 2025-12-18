package Ex1;

import java.util.Random;

public class Menu {
	
	public static String randomMenu() {
		Random ran = new Random();
		int recommend = ran.nextInt(3);
		
		String[] meal = {"라면", "김밥", "파스타", "샐러드"};
		
		int idx=ran.nextInt(meal.length);
		return meal[idx];
		
		}

	public static void main(String[] args) {
		
		System.out.println("오늘의 추천 메뉴: "+randomMenu());
		
		
		

	}

}
