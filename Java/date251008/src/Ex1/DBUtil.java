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
			return DriverManager.getConnection(URL, USER, PW); // 여기에 return 적는 거 자꾸 빼먹을래!!?!?!?!??!?!
		} catch (SQLException e) {
			System.out.println("DB 연결 실패: "+e.getMessage());
		}
		return null;
	}

}
