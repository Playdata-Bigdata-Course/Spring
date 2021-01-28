package model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//step01 - lombok 사용으로 Customer의 Car 타입의 변수엔 대입 불가
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString

//step02 - Car 스프링빈을 Customer 스프링 빈에게 주입하는 애노테이션 
//스프링 빈 등록 기술 : 생성자 주입 또는 프로퍼티 주입
@NoArgsConstructor
@Getter

@Component
public class Customer {
	private String name;
	private int age;
	@Autowired
	private Car car;
	
	//parameter 타입과 일치되는 spring bean을 스프링 framework가 찾아서 자동 주입
//	@Autowired
//	public Customer(Car car) {
//		this.car = car;
//		System.out.println("Customer(Car car)");
//	}
	
	//오류 왜? Car만 스프링 빈으로 등록 되어 있는 설정으로 String name, int age값 처리를 미흡하게 했기 때문
	//@Autowired
//	public Customer(String name, int age, Car car) {
//		super();
//		this.name = name;
//		this.age = age;
//		this.car = car;
//		System.out.println("Customer(String name, int age, Car car)");
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	//parameter 타입과 일치되는 spring bean을 스프링 framework가 찾아서 자동 주입
//	@Autowired
//	public void setCar(Car car) {
//		this.car = car;
//		System.out.println("setCar(Car car)");
//	}
	
	
}
