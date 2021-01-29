package running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.biz.schema.Car;

public class Test {

	public static void main(String[] args) {
		//컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("playdataaround.xml");
		
		Car car = context.getBean("car", Car.class);
		
		
		try {
			car.saleMoney(10);
		} catch (Exception e) {
			
		}
	}
}
