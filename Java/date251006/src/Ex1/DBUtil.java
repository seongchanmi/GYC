package Ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "c##osaka";
	private static final String PW = "1234";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PW);
		} catch (SQLException e) {
			// DB 관련 에러 처리
			System.out.println("DB 연결 실패: "+e.getMessage());
		} catch (Exception e) {
			// 그 외의 다른 예외 처리
			System.out.println("기타 오류 발생: " + e.getMessage());
		}
		return null; // "DB 연결에 실패했거나, 아직 연결 객체를 반환하지 못했을 대 null값을 대신 반환하겠다"
	}

}
