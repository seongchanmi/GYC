package ch1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

	private List<OrderDTO> orderList = new ArrayList<>();

	private String filename;

	public OrderDAO(String filename) {
		this.filename = filename;
		this.orderList = loadCsv(filename);
	}

	private List<OrderDTO> loadCsv(String filename) {
		List<OrderDTO> list = new ArrayList<OrderDTO>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String line;
			boolean isSkip = true;

			while ((line = br.readLine()) != null) {
				if (isSkip) {
					isSkip = false;
					continue;
				}

				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0].trim());
				String name = parts[1].trim();
				int price = Integer.parseInt(parts[2].trim());
				int limit = Integer.parseInt(parts[3].trim());
				int stock = Integer.parseInt(parts[4].trim());

				list.add(new OrderDTO(id, name, price, limit, stock));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage() + "그 외 모든 오류");
		}
		return list;
	}

	public void save(OrderDTO dto) {
		orderList.add(dto);
		writeCSV();
	}

	// CSV 파일에 저장
	private void writeCSV() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filename));
			pw.println("id, name, price, limit, stock");
			for (OrderDTO dto : orderList) {
				pw.printf("%d, %s, %d, %d, %d", dto.getId(), dto.getName(), dto.getPrice(), dto.getLimit(),
						dto.getStock());
			}
		} catch (IOException e) {
			System.out.println("저장 실패" + e.getMessage());
		}
	}

	public List<OrderDTO> findAll() {
		return orderList;
	}

	public OrderDTO findById(int id) {
		for (OrderDTO dto : orderList) {
			if (dto.getId() == id) {
				return dto;
			}
		}
		return null;
	}

	public boolean deleteById(int id) {
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getId() == id) {
				orderList.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean updateDAO(int id, String newName, int newPrice, int newLimit, int newStock) {
		OrderDTO dto = findById(id);
		if (dto != null) {
			dto.setName(newName);
			dto.setPrice(newPrice);
			dto.setLimit(newLimit);
			dto.setStock(newStock);
			return true;
		}
		return false;
	}

	public int count() {
		return orderList.size();
	}

}
