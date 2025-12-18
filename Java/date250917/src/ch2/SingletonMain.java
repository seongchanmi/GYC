package ch2;

public class SingletonMain {

	public static void main(String[] args) {
		

		
		/* 일반 객체인 경우 객체명을 달리해 사용 가능
		 * 객체를 한 번에 한 개만 생성 가능 
		Singleton s1 = new Singleton;
		Singleton s2 = new Singleton;
		*/
		
		//싱글톤 불러오는 방식
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if(s1==s2) {
			System.out.println("s1==s2: 항상 같은 객체입니다.");
		} else {
			System.out.println("s1!=s2: 다른 객체입니다.");
		}

		ClassEx2 c1 = new ClassEx2();
		ClassEx2 c2 = new ClassEx2();
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1==c2);; //false, 객체 참조 변수를 출력, 서로 다른 객체
	 
	}

}
