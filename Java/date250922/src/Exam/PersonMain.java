package Exam;

public class PersonMain {

	public static void main(String[] args) {

		Person[] p = new Person[5];

		String[] name = { "성찬미", "정소영", "김현정", "최정민", "성지혜" };
		int[] age = { 27, 26, 25, 25, 35 };
		String[] address = { "광주", "서울", "천안아산", "서울", "광주" };

		for (int i = 0; i < p.length; i++) {
			p[i] = new Person();
			p[i].setName(name[i]);
			p[i].setAge(age[i]);
			p[i].setAddress(address[i]);
		}

		for (int i = 0; i < p.length; i++) {
			p[i].showInfo();
		}

	}

}
