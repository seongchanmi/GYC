package hw1;

import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

	private List<AnimalDTO> animalList = new ArrayList<>();
	
	public void save(AnimalDTO dto) {
		animalList.add(dto);
	}
	
	public List<AnimalDTO> findAll(){
		return animalList;
	}
	
}
