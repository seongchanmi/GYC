package Exam;

import java.util.ArrayList;
import java.util.List;

public class GourmetDAO {
	
	private List<GourmetDTO> gourmetList = new ArrayList<>();

	public void save(GourmetDTO dto) {
		gourmetList.add(dto);
	}

	public List<GourmetDTO> findAll() {
		return gourmetList;
	}

	public GourmetDTO findByName(String name) {
		for(GourmetDTO dto : gourmetList) {
			if(dto.getName() == name) {
				return dto;
			}
		}
		return null;
	}

	public boolean deleteByName(String name) {
		for(int i = 0; i < gourmetList.size(); i++) {
			if(gourmetList.get(i).getName() == name) {
				gourmetList.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean updateDAO(String name, String reName, String reVisitDate, String reMenu, int reRating) {
		GourmetDTO dto = findByName(name);
		if(dto != null) {
			dto.setName(reName);
			dto.setVisitDate(reVisitDate);
			dto.setMenu(reMenu);
			dto.setRating(reRating);
			return true;
		}
		
		return false;
	}
	
	
	

}
