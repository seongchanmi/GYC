package ch1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DB에서 불러온 데이터 작업을 DAO에서 함
//연결, 예외 처리, 자원반납 등등...
public class YoutubeDAO {

	// 전체 조회
	public List<YoutubeDTO> selectAllYoutube() {
		List<YoutubeDTO> list = new ArrayList<>();
		String sql = "select * from youtube"; // 해당 문자열을 sql로 보내줌

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			// .prepareStatement(sql); : DB와 sql구문으로 소통하는 통로
			// try(...){} 의 소괄호 안 (...)에 넣어서 자동으로 close() 해줌
			// ResultSet : 결과를 돌려 받기 위한 객체
			
			while (rs.next()) { // .next() : 데이터의 줄을 읽음. 줄이 없으면 false 반환으로 while문 종료
				
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String ch_name = rs.getString("ch_name");
				Date upload = rs.getDate("upload");
				int views = rs.getInt("views");
				int likes = rs.getInt("likes");

				YoutubeDTO dto = new YoutubeDTO(id, title, ch_name, upload, views, likes);
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());
		}
		return list;
	}

}
