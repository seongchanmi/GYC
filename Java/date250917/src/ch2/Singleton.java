package ch2;

/*
 * 싱글톤 패턴 
 * 클래스에서 오직 하나의 객체만 만들 수 있게 하는 디자인 패턴
 * 단 하나의 인스턴스(객체)만 존재
 * 생성자는 private, 객체는 static 변수에 저장
 * getInstance()로 객체를 얻음
 * 주로 DB연결, 로스, 설정 등에 사용
 * 
 */

public class Singleton {
	
	//자신의 객체를 static 미리 생성
	private static Singleton instance = new Singleton();
	
	// 생성자 private로 제한을 두어 외부에서 접근 제한 
	private Singleton() {}
	
	int num;
	
	//객체를 외부에서 가져올 수 있는 메서드 작성
	public static Singleton getInstance() {
		return instance;
		
	}
}
