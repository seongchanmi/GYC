package ch1;

public class MethodEx1 {
	
	public static void sayHello() {
		System.out.println("Hello Java");
	}
	
	public static void callName(String name) {
		System.out.println("안녕하세요, "+name+"님!!!");
	}
	
	public static int square(int x) { //void는 "데이터 타입이 없음"을 의미
		// public static int square(int x) -> void 대신 int를 쓰면 square의 데이터 타입을 정의
		return x * x;		//return 키워드를 단독으로 쓰면 그 구문을 아예 빠져 나가버리기 때문에...
	}
	
	//매개변수 age의 값이 19이상일 때, true/false 변환
	public static boolean isAdult(int age) {
		return age >= 19; 
		// 다른 건 다 지금 그대로인 상태에서
		//처음에 return age;로만 작성했더니 에러 떴었는데.. return age >=19;로 하니까 해결됨
		
	}
	
	// 매개변수 name을 받아 "Hello, " + name으로 반환
	public static String helloTo(String name) {
		return "Hello, "+name;
		//return name; 은 안되나요 >>> 됩니다
	}
	 
	public static void printSum(int a, int b) {
		//void 리턴값이 없을 때. 실행만 함
		System.out.println("void: "+(a+b));
	}

	public static int getSum(int a, int b) {
		//리턴값 있음
		return a+b;
	}
	
	//메서드 오버로딩: 이름 같고 매개변수만 다르게 하여 여러 메서드를 정의하는 것
	public static int multi(int a, int b) {
		return a + b;
		//a,b에 정수가 들아가면 자동으로 알아서 a+b를 돌려주고
	}
	public static double multi(double a, double b) {
		return a * b;
		//a,b에 실수가 들아가면 자동으로 알아서 a*b를 돌려주고
	}

	
	// ===========메서드 호출 영역 (main 메서드 영역에서 호출)===========
	public static void main(String[] args) {
		// 결과를 돌려받지 않고 실행만 함

		sayHello();
		
		// 매개변수가 있는 메서드 
		callName("한라봉");
		
		// 매개변수로 보낸 값을 정수로 돌려받음
		System.out.println("x * x = "+square(15));
		
		//매개변수로 보낸 값을 true/false로 받음
		System.out.println("성인: " + isAdult(18));
		
		//매개변수로 보낸 값을 문자열로 받음
		String hello = helloTo("성찬미");
		System.out.println(hello);
		//System.out.println(helloTo("성찬미"));
		//System.out.println("Hello, " + helloTo("성찬미")); 
		
		//void VS return
		printSum(7, 8); //메서드 안에 출력문이 있어 바로 출력
		
		int result = getSum(7, 8); //메서드 안에서 값만 리턴
		System.out.println(result);
		 
		//메서드 오버로딩
		System.out.println(multi(2, 3)); //2 + 3
		System.out.println(multi(2.124, 3.2416)); //2.124 * 3.2416
		//multi의 이름이 같지만 알아서 찾아서 그 타입에 맞는 결과값을 출력해줌
	}

}
