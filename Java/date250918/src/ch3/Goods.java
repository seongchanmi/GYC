package ch3;

/*
 * 추상화 abstract
 * 완전하지 않은 클래스
 * 공통 특징 정의, 구현은 자식 클래스 
 * 직접 객체(인스턴스)를 만들 수 없음. new 추상클래스() x
 * 
 */

public abstract class Goods {
	
	private String brand;
	
	public Goods(String brand) {
		this.brand= brand;
	}
	
	//추상 메서드 
	public abstract void turnOn();
	public abstract void turnOff();
	
	// 일반 메서드 (공통 메서드)
	public void showBrand() {
		System.out.println("브랜드: "+ brand);
	}
	
	
}
