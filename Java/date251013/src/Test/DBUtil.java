package Test;

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
			System.out.println("DB 연결 실패: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 오류 발생: " + e.getMessage());
		}
		return null;
	}

}
