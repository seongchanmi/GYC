package ch1;

public class BreadMain {

	public static void main(String[] args) {
		//좋아하는 빵의 객체의 생성자를 만들어 해당 제품명과 금액을 처리한 후 출력
		
		
		//기본 생성자 + setter 메서드 (매개변수 없음)
		Bread bread1 = new Bread();
		
		System.out.println("제품명: " + bread1.getName()+", 무게: "+bread1.getGram()+", 가격:"+bread1.getPrice()+
				", 수량"+bread1.getCnt()+" / 합계: "+bread1.breadTotal());
		
		
		bread1.setName("밤식빵");
		bread1.setGram(50);
		bread1.setPrice(5000);
		bread1.setCnt(3);
		
		System.out.println("제품명: " + bread1.getName()+", 무게: "+bread1.getGram()+", 가격:"+bread1.getPrice()+
				", 수량"+bread1.getCnt()+" / 합계: "+bread1.breadTotal());
		
		// ================= 여기까지 매개 변수가 없을 때의 경우==================
		
		
		//매개변수가 있는 생성자. 값을 다 알고 있고 한 번에 넣고자 할 때
		Bread bread2 = new Bread("소금빵", 80, 3000, 2);
		System.out.println("제품명: "+bread2.getName()+", 합계: "+bread2.breadTotal());
		
		
		//클래스에 있는 toString 메서드로 출력해줌
		Bread bread3 = new Bread();
		bread3.setName("밤식빵");
		bread3.setGram(350);
		bread3.setPrice(5000);
		bread3.setCnt(3);
		System.out.println(bread3);
		
		Bread bread4 = new Bread("건포도식빵",400,5500,2);
		System.out.println(bread4.toString());
		 
	}

}
