package ch1;

import java.util.ArrayList;
import java.util.List;

//회원 리스트 저장, 조회

public class StudentDAO {
	// 실제 학생 정보를 추가. 순서 있게 저장. 데이터를 담는 컬렉션 객체
	private List<StudentDTO> studentList = new ArrayList<>();

	public void save(StudentDTO dto) {
		studentList.add(dto); //데이터 추가
	}
	
	//회원정보 조회(출력)
	public List<StudentDTO> findAll(){
		return studentList;
	}
}
