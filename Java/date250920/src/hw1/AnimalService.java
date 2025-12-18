package hw1;

import java.util.List;

public class AnimalService {
	
	private AnimalDAO dao;
	public AnimalService(AnimalDAO dao) {
		this.dao = dao;
	}

	public void addAnimal(String id, String guardian, String name, int age, String phone) {
		AnimalDTO dto = new AnimalDTO(id,guardian, name, age, phone);
		dao.save(dto);
	}
	
	public List<AnimalDTO> getAllAnimal() {
		return dao.findAll();
	}
}
