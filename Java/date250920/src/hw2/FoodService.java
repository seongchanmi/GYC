package hw2;

import java.util.List;

public class FoodService {
	
	private FoodDAO dao;
	public FoodService(FoodDAO dao)	{
		this.dao = dao;
	}

	public void addFood(int num, String name, int amount, String date) {
		FoodDTO dto = new FoodDTO(num, name, amount, date);
		dao.save(dto);
		}
	
	public List<FoodDTO> getAllFood() {
		return dao.findAll();
		}
	 
}
