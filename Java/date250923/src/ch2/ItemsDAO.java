package ch2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * DB/items.csv을 읽어와 리스트로 저장
 * CRUD 작업 후 다시 .csv 파일로 저장
 * 
 */

//저장소에서 데이터 처리
public class ItemsDAO {

	// 상품 리스트 저장
	private List<ItemsDTO> itemsList = new ArrayList<>();
	// DTO를 기반으로 리스트 작성

//	private List<ItemsDTO> itemsList;
	private String filename;

	public ItemsDAO(String filename) {
		this.filename = filename;
		this.itemsList = loadCsv(filename);
	}

	// csv 파일에서 내용 읽기
	private List<ItemsDTO> loadCsv(String filename) {
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		/*
		 * try-catch : 프로그램 실행 중 오류가 발생해도 프로그램이 멈추지 않고, 돌아가게 해줌
		 * 
		 * BufferedReader br = new BufferedReader(new FileReader(filename)); 문서를 한 줄씩 읽게
		 * 해줌
		 */
		
		// try(...)-with-resources (자동닫기)
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) { // try() 소괄호 안에 넣으면 자동 닫기가 됨
			
			String line; // 외부 파일에서 읽어온 한 줄의 데이터를 저장
			boolean isSkip = true;

			while ((line = br.readLine()) != null) { // 한 줄씩 읽다가 마지막 줄을 읽고 나면 null이 되니까 종료

				if (isSkip) { // 처음 문서를 읽으면 첫 번째 줄부터 읽음. true
					isSkip = false; // 변수를 false; 로 해줘서 두 번째 줄을 읽을 때는 isSkip이 false라서 실행 안하고 넘어가게 해줌
					continue;// continue-> 해당줄 건너뛰기. 첫 번째 줄(해당 줄)은 건너뛰기, 혹은 넘어간 뒤 다시 반복
				}

				// 문자열 배열로 저장
				String[] parts = line.split(","); // 쉼표를 기준으로 나누기
				int id = Integer.parseInt(parts[0].trim()); // 문자열로 나눈 것을 정수로 변환. .trim-> 앞뒤로 여백을 없애라

				String name = parts[1].trim();
				int qty = Integer.parseInt(parts[2].trim());
				int price = Integer.parseInt(parts[3].trim());

				// 새로운 ItemsDTO 객체를 만들고 리스트에 추가
				list.add(new ItemsDTO(id, name, qty, price));
			}

		} catch (FileNotFoundException e) { // <- 문서를 찾지 못한 에러
			e.printStackTrace(); // 에러가 생기면 그 내용을 출력하걸아~
		} catch (Exception e) { // 그 외의 모든 오류
			System.out.println(e.getMessage() + "그 외 모든 오류");
		}
		return list;
	}

	// 상품 등록(추가)
	public void save(ItemsDTO dto) {
		itemsList.add(dto);
		writeCSV();
	}

	// CSV파일에 저장
	private void writeCSV() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(filename));
			pw.println("id, name, qty, price"); // 타이틀
			for (ItemsDTO dto : itemsList) {
				pw.printf("%d, %s, %d, %d\n", dto.getId(), dto.getName(), dto.getQty(), dto.getPrice());
			}
		} catch (Exception e) {
			System.out.println("저장 실패" + e.getMessage());
		} finally {
			pw.close();
		}
	}

	// 전체 목록 반환
	public List<ItemsDTO> findAll() {
		return itemsList;
	}	

	
	
	// 아이디로 상품 찾기(개별 목록 반환)
	/*
	public ItemsDTO findById(int id) {
		for (ItemsDTO dto : itemsList) {
			if (dto.getId() == id)
				return dto;
		}
		return null;
	}
	*/
	
	public ItemsDTO findById(int id) {
		return itemsList.stream()
		.filter(item -> item.getId() == id)
		.findFirst()
		.orElse(null); // else와 같은 역할로 위의 조건을 만족하지 못하면 null
	}


	// 상품 삭제
	/*
	public boolean deleteById(int id) {
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getId() == id) { //get(i) -> 인덱스 값을 가져와서
				itemsList.remove(i);
				writeCSV(); // 순서에 주의
				return true;
			}
		}
		return false;
	}
	*/
	
	public boolean deleteById(int id) {
		//조건에 맞으면 객체 전부를 한 번에 삭제
		boolean removeItem = itemsList.removeIf(item -> item.getId() == id); 
		// itemsList에서 item 하나만 가져와서 매개변수로 받은 id랑 비교하겠다
		if(removeItem) writeCSV(); //값이 참인 경우 다시 호출
		return removeItem;
	}

	// 수정은 보통 DTO 객체 자체를 받아서 setter를 통해서 값 변경 처리
	public boolean updateDAO(int id, String newName, int newQty, int newPrice) {
		ItemsDTO dto = findById(id);
		if (dto != null) {
			dto.setName(newName);
			dto.setQty(newQty);
			dto.setPrice(newPrice);
			writeCSV();
			return true;
		}
		return false;
	}

	public int count() {
		return itemsList.size();
	}

}
