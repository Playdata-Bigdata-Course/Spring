package model.domain;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("기본 생성자");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setName()");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		System.out.println("setAge()");
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("생성자");
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	
}
