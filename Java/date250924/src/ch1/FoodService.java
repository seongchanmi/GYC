package ch1;

public class FoodService {

	public FoodDAO dao;

	public FoodService(FoodDAO dao) {
		this.dao = dao;
	}

	int nextId = 1;

	public void saveAllFoods(int id, String name, int price, int qty, String date) {
		FoodDTO dto = new FoodDTO(nextId++, name, qty, price, date);
		dao.save(dto);

	}

}
