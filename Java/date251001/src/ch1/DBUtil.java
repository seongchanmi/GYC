package ch1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속 주소
	private static final String USER = "c##osaka"; // 계정
	private static final String PW = "1234"; // 비밀번호

	// 커넥션 객체 반환 메서드. (finally 이나 다른 방법으로 여기서 자원을 닫으면 안되고, 사용하는 쪽에서 자원을 닫아야 문제가 안
	// 생김)
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PW);// 직접 넣기 너무 길어서 URL,USER,PW 변수 생성
		} catch (Exception e) {
			System.out.println("DB 연결 실패: " + e.getMessage());

		}

		return null;
	}

}
