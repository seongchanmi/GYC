package Ex1;

import java.util.List;

public class TripService {

	private TripDAO dao = new TripDAO();
	
	public List<TripDTO> getAllTrip(String ans) {
		return dao.selectBySeason(ans);
	}

}
