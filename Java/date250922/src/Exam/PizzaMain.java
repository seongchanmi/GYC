package Exam;

public class PizzaMain {

	public static void main(String[] args) {

		Pizza ord1 = new Pizza();
		ord1.type = "페퍼로니";
		ord1.size = "L";
		ord1.price = 15000;
		ord1.pizza();
		System.out.println();

		Pizza ord2 = new Pizza();
		ord2.type = "하와이안";
		ord2.size = "M";
		ord2.price = 13000;
		ord2.pizza();
		System.out.println();

		Pizza ord3 = new Pizza();
		ord1.type = "치즈";
		ord1.size = "S";
		ord1.price = 9000;
		ord1.pizza();
		System.out.println();

	}

}
