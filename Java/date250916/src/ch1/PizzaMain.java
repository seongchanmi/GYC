package ch1;

public class PizzaMain {

	public static void main(String[] args) {
		
		Pizza pizza = new Pizza();
		pizza.type = "페퍼로니"; 
		pizza.size = "L";
				
		System.out.println("피자 종류는: "+pizza.type);
		System.out.println("피자 사이즈는: "+pizza.size);

	}

}