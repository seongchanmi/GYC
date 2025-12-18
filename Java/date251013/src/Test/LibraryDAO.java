package Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {

	public List<LibraryDTO> selectAllLibrary() {
		List<LibraryDTO> list = new ArrayList<>();
		String sql = "select * from Library";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date publishDate = rs.getDate("publishDate");
				int rating = rs.getInt("rating");

				LibraryDTO dto = new LibraryDTO(id, title, author, publishDate, rating);
				list.add(dto);
			}

		} catch (SQLException e) {
			System.out.println("DB 관련 오류: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("그 외의 오류: " + e.getMessage());
		}
		return list;
	}

}
