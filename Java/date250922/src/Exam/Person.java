package Exam;

public class Person {

	private String name;
	private int age;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void showInfo() {
		System.out.println("이름: " + name + ", 나이: " + age + ", 주소: " + address);
	}

}
