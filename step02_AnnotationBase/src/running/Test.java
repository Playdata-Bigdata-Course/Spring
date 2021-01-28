package running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.domain.Car;
import model.domain.Customer;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("playdata.xml");
		
		//step01 - @Component와 @Scope 연습만 진행
//		Car c1 = context.getBean("car", Car.class); //@component
//		Car c1 = context.getBean("c", Car.class); 	//@Compoenet("c"
//		System.out.println(c1);
//
//		Car c2 = context.getBean("car", Car.class);
//		System.out.println(c2);
		
		//step02 - 
		Customer cust1 = context.getBean("customer", Customer.class);
		System.out.println(cust1); 			//Customer 주소값만 출력
		System.out.println(cust1.getCar()); //Car 주소값만출력 
		
		
		//case1 : Customer 스프링빈/ Car 스프링 빈이 아님 
		//cust1.setCar(new Car("a", 77));
		
		//case2 : Customer 스프링빈/ Car 스프링 빈
		//scope="prototype" Car는 언제 어떻게 Customer의 car 변수에 대입(주입)하나? 방식은 또 어떻게? ..??? 엄청 사용빈도 높음
		
	}
}
