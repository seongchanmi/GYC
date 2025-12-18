package ch5;

public class PersonMain {

	public static void main(String[] args) {
		Person[] p = new Person[5];
		
		for(int i=0; i<p.length; i++) {
			p[i] = new Person();
		}
		
		p[0].setName("성찬미");
		p[0].setAge(27);
		
		p[1].setName("정소영");
		p[1].setAge(26);
		
		p[2].setName("김현정");
		p[2].setAge(25);

		p[3].setName("최정민");
		p[3].setAge(25);
		
		p[4].setName("성지혜");
		p[4].setAge(35);
		
		for(int i=0; i<p.length; i++) {
			p[i].showPerson();
		}
	}


}
