package ch1;

import java.util.List;

public class YoutubeService {

	private YoutubeDAO dao = new YoutubeDAO();

	public List<YoutubeDTO> getAllYoutube() {
		return dao.selectAllYoutube();
	}

}
