package ch1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DB에서 불러온 데이터 작업을 DAO에서 함. CHRD
//연결, 예외 처리, 자원반납...
public class YumDAO {

	// 전체 조회
	public List<YumDTO> selectAllYum() {
		List<YumDTO> list = new ArrayList<>();
		String sql = "select * from yum order by id"; // 이 구문을 sql로 보내주는 것임

		// .prepareStatement(sql); DB와 sql 구문으로 소통하는 통로
		try (Connection conn = DBUtil.getConnection(); // 자동으로 닫아주기 위해서 try 옆에 소괄호 () 달아주기
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// ResulSet 결과를 돌려 받기 위한 객체
				ResultSet rs = pstmt.executeQuery()) {
			// .next() 데이터의 줄 읽음
			while (rs.next()) { // 줄이 없으면 false 반환으로 종료
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date visitDate = rs.getDate("visitDate");
				String menu = rs.getString("menu");
				int rating = rs.getInt("rating");
				Date regDate = rs.getDate("regDate");

				YumDTO dto = new YumDTO(id, name, visitDate, menu, rating, regDate);
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());
		}
		return list;
	}

	// 등록
	public boolean insertYum(YumDTO dto) {

		// ? : 나중에 값을 대입할 때
		String sql = "insert into yum (name,visitDate, menu, rating) values (?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dto.getName());
			pstmt.setDate(2, dto.getVisitDate());
			pstmt.setString(3, dto.getMenu());
			pstmt.setInt(4, dto.getRating());

			int result = pstmt.executeUpdate(); // 등록이나 수정시엔 executeUpdate
			return result > 0; // 이 결과의 값이 참이면 true를 반환

		} catch (Exception e) {
			System.out.println("YUM 등록 오류: " + e.getMessage());
		}
		return false;
	}

	// 개별 조회
	public YumDTO selectYumById(int id) {

		String sql = "select * from yum where id = ?";
		YumDTO item = null;

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id); // '첫 번째 ? 자리에 id가 들어간다'

			try (ResultSet rs = pstmt.executeQuery();) {

				if (rs.next()) {
					String name = rs.getString("name");
					Date visitDate = rs.getDate("visitDate");
					String menu = rs.getString("menu");
					int rating = rs.getInt("rating");
					Date regDate = rs.getDate("regDate");

					item = new YumDTO(id, name, visitDate, menu, rating, regDate);
				}

			} catch (Exception e) {
				System.out.println("개별 조회 오류: " + e.getMessage());
			}
		} catch (Exception e) {

		}
		return item; // return은 나를 호출한 곳으로 값을 돌려준다고
	}

	// 수정(id로 찾아서 데이터 수정)
	public int updateYum(YumDTO dto) {
		String sql = "update yum set name=?, visitDate=?, menu=?, rating=?, regDate=sysdate where id =?"; // regdate =
																											// sysdate
																											// 수정
		int result = 0;

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dto.getName());
			pstmt.setDate(2, dto.getVisitDate());
			pstmt.setString(3, dto.getMenu());
			pstmt.setInt(4, dto.getRating());
			pstmt.setInt(5, dto.getId());
			result = pstmt.executeUpdate(); // 이 결과의 값이 참이면 0

		} catch (Exception e) {
			System.out.println("수정 오류" + e.getMessage());
		}

		return result;
	}

	// 삭제
	public int deleteYum(int id) {
		String sql = "delete from yum where id = ?";
		int result = 0;

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			// pstmt.executeUpdate(); 만 해도 실행은 되지만, 삭제가 되었다고 사용자에게 반환하기 위해서 result에 정수(0)를
			// 저장해서 result를 반환해줌

		} catch (Exception e) {
			System.out.println("삭제 오류: " + e.getMessage());
		}
		return result;
	}

	// 전체 맛집 수
	public int getAllCount() {
		String sql = "select count(*) from yum";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("총합 오류: " + e.getMessage());
		}
		return 0;
	}

	public double getAvgRating() {
		String sql = "select avg(rating) from yum";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				return rs.getDouble(1);
			}

		} catch (Exception e) {
			System.out.println("평점 평균 오류: " + e.getMessage());
		}

		return 0.0; // 실수로 반환하기 때문에 여기의 return 값을 0.0으로 써줘야 함!!!!! 반드시!!!!!!
	}

	public int getCountRating(int i) {

		String sql = "select count(*) from yum where rating >= ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, i);
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					return rs.getInt(1);
				}

			}

		} catch (Exception e) {
			System.out.println("4점 가게 오류: " + e.getMessage());
		}
		return 0;
	}

}
