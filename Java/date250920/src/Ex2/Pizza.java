package Ex2;

public class Pizza {
	
	String type;
	String size;
	
	Pizza(String type, String size)	{
		this.type = type;
		this.size = size;
	}
	
	void pizza () {
		System.out.println("주문하신 "+this.type +" 피자 "+ this.size+"사이즈 드립니다.");
	}

}
	


