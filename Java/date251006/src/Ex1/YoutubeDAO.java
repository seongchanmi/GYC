package Ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YoutubeDAO {

	public List<YoutubeDTO> selectAllYoutube() {
		List<YoutubeDTO> list = new ArrayList<>();
		String sql = "select * from youtube";
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String ch_name = rs.getString("ch_name");
				Date upload = rs.getDate("upload");
				int views = rs.getInt("views");
				int likes = rs.getInt("likes");
				
				YoutubeDTO dto = new YoutubeDTO(id, title, ch_name, upload, views, likes);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("DB 관련 오류: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("그 외의 오류: "+e.getMessage());
		}
		return list;
				
		
	}

	
}
