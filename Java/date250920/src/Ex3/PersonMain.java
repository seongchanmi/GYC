package Ex3;

//가희의 조언대로 수정함

public class PersonMain {

	public static void main(String[] args) {

		Person[] p = new Person[6]; 
		// 사람 수가 늘어나도 Person[6] 대괄호 안에 숫자만 변경하고
		// String[] name과 int[] age 안에 데이터만 추가로 입력해주면 됨
		// 수정이 용이함

		// 이름과 나이를 배열로 준비
		String[] name = { "성찬미", "정소영", "김현정", "최정민", "성지혜","최가희"};
		int[] age = { 27, 26, 25, 25, 35, 26 };

		// for문으로 Person 객체 생성 + 값 초기화
		for (int i = 0; i < p.length; i++) {
			p[i] = new Person();
			p[i].setName(name[i]);
			p[i].setAge(age[i]);
		}

		// for문으로 출력
		for (int i = 0; i < p.length; i++) {
			p[i].showPerson();
		}

	}

}
