package hw3;

import java.util.List;

public class HealthService {
	private HealthDAO dao;
	public HealthService(HealthDAO dao) {
		this.dao = dao;
	}
	
	public void addHealth (String name, int num, int goal, int result) {
		HealthDTO dto = new HealthDTO(name, num, goal, result);
		dao.save(dto);
	}
	
	public List<HealthDTO> getAllHealth(){
		return dao.findAll();
		}
}
