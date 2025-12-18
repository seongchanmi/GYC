package ch1;
// 메인 메서드만 넣음
public class DogMain {
	
	public static void main(String[] args) {
		// Dog 클래스(설계도)로 실제 강아지(객체) 만들기
		Dog dog1 = new Dog("흰둥이", 2, "흰색","진돗개",6,true);
		Dog dog2 = new Dog("솜이", 6, "흰색","사모예드",20,true);
		
		
		//동작
		dog1.eat();
		dog2.pupu();
	}
}
