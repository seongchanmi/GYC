package ch1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateList {

	public static void main(String[] args) {
		List<ListDTO> list = new ArrayList<>();

		list.add(new ListDTO(10, "한라봉")); // 인덱스 0
		list.add(new ListDTO(20, "진지향")); // 인덱스 1
		list.add(new ListDTO(30, "레드향")); // 인덱스 2
		list.add(new ListDTO(40, "윈터프린스")); // 인덱스 3

		int updateId = 30; // 수정번호
		String newName = "Orange"; // 바꿀이름

		// 인덱스 for문 수정
		System.out.println("==for문 수정==");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == updateId) {
				list.get(i).setName(newName);
				break;
			}
		}

		System.out.println(list);

		list.clear();
		list.add(new ListDTO(10, "한라봉")); // 인덱스 0
		list.add(new ListDTO(20, "진지향")); // 인덱스 1
		list.add(new ListDTO(30, "레드향")); // 인덱스 2
		list.add(new ListDTO(40, "윈터프린스")); // 인덱스 3
		
		// Iterator 수정
		System.out.println("==iterator수정==");
		Iterator<ListDTO> it = list.iterator();
		while (it.hasNext()) {
			ListDTO dto = it.next();// 가져옴
			if (dto.getId() == updateId) {
				dto.setName(newName);
				break;
			}
		}

		System.out.println(list);

		list.clear();
		list.add(new ListDTO(10, "한라봉")); // 인덱스 0
		list.add(new ListDTO(20, "진지향")); // 인덱스 1
		list.add(new ListDTO(30, "레드향")); // 인덱스 2
		list.add(new ListDTO(40, "윈터프린스")); // 인덱스 3
		
		// for-each문 수정
		System.out.println("==== for-each문 수정 ==");
		for (ListDTO dto : list) {
			if (dto.getId() == updateId) {
				dto.setName(newName);
				break;
			}
		}

		System.out.println(list);
		
		list.clear();
		list.add(new ListDTO(10, "한라봉")); // 인덱스 0
		list.add(new ListDTO(20, "진지향")); // 인덱스 1
		list.add(new ListDTO(30, "레드향")); // 인덱스 2
		list.add(new ListDTO(40, "윈터프린스")); // 인덱스 3
		
		// stream 수정
		System.out.println("=== stream 수정==");
		list.stream()
		.filter(dto -> dto.getId() == updateId)
		.forEach(dto -> dto.setName(newName));
		
		
		System.out.println(list);
	}

}
