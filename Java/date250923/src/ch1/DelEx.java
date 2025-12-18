package ch1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DelEx {

	public static void main(String[] args) {
		List<ListDTO> list = new ArrayList<>();
		
		list.add(new ListDTO(10, "한라봉"));
		list.add(new ListDTO(20, "진지향"));
		list.add(new ListDTO(30, "레드향"));
		list.add(new ListDTO(40, "윈터프린스"));

		int deleteId = 30;

		System.out.println("==인덱스 기반 삭제==");
		// 1. 인덱스 기반 삭제
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == deleteId) {
				list.remove(i);
				break;
			}
		}
		System.out.println(list);

		list.clear();
		list.add(new ListDTO(10, "한라봉"));
		list.add(new ListDTO(20, "진지향"));
		list.add(new ListDTO(30, "레드향"));
		list.add(new ListDTO(40, "윈터프린스"));

	
		//2. Iterator(반복자) 삭제
		System.out.println("==========반복자 삭제============");
		//List와 같이 여러 데이처를 차례대로 꺼낼 수 있게 도와주는 객체
		// 반복하면서 삭제, 변셩시에는 반드기 필요
		Iterator<ListDTO>it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getId() == deleteId) {
				it.remove();
				break;
			}
			
		}
	
		//3.Stream 삭제
		//List, Set, 배열 등 여러 데이터를 반복문 없이 처리할 수 있게 도와주는 클래스
		//데이터를 한 줄로 꺼내 차례대로 제어.
		//method1(), method2(); 메서드 체이닝 가능
		/*
		.filter();
		.map(); 값 변환
		.forEach();각 요소의 반복 출력
		.findFirst(); 첫번째 값 출력
		 */
	
	
		System.out.println("===Stream삭제===");
		// 조건에 맞는 객체는 모두 한 번에 삭제
	
		list.removeIf(n -> n.getId() == deleteId);
	
		System.out.println(list);
	
		list.clear();
		list.add(new ListDTO(10, "한라봉"));
		list.add(new ListDTO(20, "진지향"));
		list.add(new ListDTO(30, "레드향"));
		list.add(new ListDTO(40, "윈터프린스"));
	
		// 4. Stream +collect = 원본 리스트는 변하지 않음
		System.out.println("==Stream + collect 삭제==");
		List<ListDTO> newList = list.stream()
			.filter(n -> n.getId() != deleteId)
			.toList(); // .filler() 30번과 같지 않은 데이터를 걸러 .toList 리스트에 모으겠다.
		System.out.println(newList);
		System.out.println("원본:"+list);
}
		
	}

