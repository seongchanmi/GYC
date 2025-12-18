package Exam;

import java.util.List;

public class GourmetService {

	private GourmetDAO dao;

	public GourmetService(GourmetDAO dao) {
		this.dao = dao;
	}

	public void saveGourmet(String name, String visitDate, String menu, int rating) {
		GourmetDTO dto = new GourmetDTO(name, visitDate, menu, rating);
		dao.save(dto);
	}

	public List<GourmetDTO> getAllGourmet() {
		return dao.findAll();
	}

	public GourmetDTO getByName(String name) {
		return dao.findByName(name);
	}

	public boolean deleteGourmet(String name) {
		return dao.deleteByName(name);
	}

	public boolean updateGourmet(String name, String reName, String reVisitDate, String reMenu, int reRating) {
		return dao.updateDAO(name, reName, reVisitDate, reMenu, reRating);
	}


}
