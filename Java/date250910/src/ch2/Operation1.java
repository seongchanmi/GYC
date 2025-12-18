package ch2;

/*
 * 연산자란?
 * 값을 계산할 때 사용하는 기호
 *  
 */
public class Operation1 {
	
	public static void main(String[] args) {
		//산술 연산자 +, -, *, /, %
		int a = 10 + 5;
		int b = 7 - 5;
		int c = 7 * 3;
		int d = 8 / 11;
		int e = 9 % 4;	// 나머지 값
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		System.out.println("=========");
		//비교 연산자: ==, !=, >, <, >=, <=
		boolean isSame = (5 == 5); // 같다 
		// 헷갈리면 괄호 써도 되는데 그냥 boolean isSame = 5==5; 라고 써도 됨
		boolean isDiff = (10!=5); // 같지않다
		boolean isBig = (10>5); // 크다
		boolean isSmall = (1>5); // 작다
		boolean isGt = (7>=7); // 크거나 같다
		boolean isLt = (6<=4); // 작거나 같다
		
		
		
		System.out.println(isSame);
		System.out.println(isDiff);
		System.out.println(isBig);
		System.out.println(isSmall);
		System.out.println(isGt);
		System.out.println(isLt); // false
		
		System.out.println("=========");	
		// 논리 연산자: &&(and 둘 다 참), ||(or, 둘중 하나만 참), !(부정)
		boolean isOp1 = (5<2) && (10<20); 
		// 논리 연산자를 기준으로 A조건 B조건이 다 만족해야 ture
		boolean isOp2 = (3==4) || (2>1); 
		// A조건 B조건 둘 중 하나만 참
		boolean isOp3 = !(7<=5); 
		// 값의 반대, false의 부정은 true이기 때문에 true가 도출
		
		System.out.println(isOp1);
		System.out.println(isOp2);
		System.out.println(isOp3);
		
		int chnm = 5%7;
		System.out.println(chnm);
		
	}

}
