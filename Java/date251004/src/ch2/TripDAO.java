package ch2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripDAO {

	public List<TripDTO> selectBySeason(String ans) {
		
		List<TripDTO> list = new ArrayList<>();
		String sql = "select * from trip where season = ? and rating >= 4.5 order by rating desc";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, ans);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				
				String name = rs.getString("name");
				String location = rs.getString("location");
				String s = rs.getString("season");
				double rating = rs.getDouble("rating");

				TripDTO dto = new TripDTO(name, location, s, rating);
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("오류: " + e.getMessage());
		}
		return list;
	}

}
