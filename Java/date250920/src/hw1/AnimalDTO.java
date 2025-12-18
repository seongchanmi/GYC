package hw1;

public class AnimalDTO {
	
	private String id;
	private String guardian;
	private String name;
	private int age;
	private String phone;
	
	public AnimalDTO() {}

	public AnimalDTO(String id, String guardian, String name, int age, String phone) {
		this.id = id;
		this.guardian = guardian;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "아이디: " + id + ", 보호자명: " + guardian + 
		", 반려동물 이름: " + name + ", 반려동물 나이: " + age + ", 연락처: " + phone;
	}
	
	

}
