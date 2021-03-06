package running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.domain.Customer;

public class Test {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("di.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("di2.xml");
		//Car c = context.getBean("car", Car.class);
		Customer c =context.getBean("c1", Customer.class);
		System.out.println("c1=" + c + Integer.toString(c.hashCode())); //c.toString() - Object의 메소드는 주소값 반환 로직
	
		Customer c2 =context.getBean("c1", Customer.class);
		System.out.println("c2=" + c2 + Integer.toString(c2.hashCode())); 
		System.err.println(c.getCar() + Integer.toString(c.getCar().hashCode()));
		System.err.println(c2.getCar() + Integer.toString(c2.getCar().hashCode()));
	}
}
