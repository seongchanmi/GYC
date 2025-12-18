package ch1;

public class Main {

	public static void main(String[] args) {
		/*
		YumController controller = new YumController();
		controller.run(); //인스턴스(객체)를 만들어서 사용하면 그 인스턴스가 가지고 있는 메서드를 가지고 와서 사용할 수 있음
		//매개 변수 사용해서 쓰고 싶으면 이렇게
		*/
		
		new YumController().run(); // 인스턴스를 안 만들고 사용하면 딱 한 번만 사용할 수 있음. 매개변수 없이 사용하는 것임
		
	}

}

