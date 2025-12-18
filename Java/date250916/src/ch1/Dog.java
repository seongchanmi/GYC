package ch1;
// 초기값만 넣고
public class Dog {
	//속성(field): 강아지의 특성
	String name;
	int age;
	String color;
	String type;
	double weight;
	boolean vaccine;
	
	//생성자: 객체를 만들 때의 정보
	//source >> generate constructor using field
	
	public Dog(String name, int age, String color, String type, double weight, boolean vaccine) {
		//this 객체 자신을 나타내는 키워드
		//객체 자신의 필드를 참조하거나 해당 클래스의 다른 생성자를 호출할 때 사용
		//static(정적) 메서드에서는 this 사용할 수 없음
		this.name = name;
		this.age = age;
		this.color = color;
		this.type = type;
		this.weight = weight;
		this.vaccine = vaccine;
	}
	
	
	//메서드: 강아지의 동작 
	
	void eat() {
		System.out.println("잘 먹고 있어요");
	}
	void play() {
		System.out.println("잘 놀고 있어요");
	}
	void pupu() {
		System.out.println("배변 산책은 중요합니다.");
	}
	
	
}
