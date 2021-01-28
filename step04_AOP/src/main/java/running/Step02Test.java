package running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step02.biz.aop.Car;

public class Step02Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		Car car = context.getBean("biz", Car.class);
		
		System.out.println("*** 경우의 수 1 : Car의 각 메소드에 모든 로직을 구현한 경우 ***");
		car.buy();
		car.buyMoney(10);

		System.out.println("*** 경우의 수 2 : Car의 각 메소드에서 별도로 구분해서 구현한 공통 로직 클래스의 메소드를 직접 호출한 경우 ***");
		car.buy2();
		car.buyMoney2(10);
	}
}
