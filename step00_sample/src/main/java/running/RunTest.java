package running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.domain.Person;

public class RunTest {
	
	//step01
	//public static void main(String[] args) {
//		//컨테이너 기능의 객체 생성
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
//		
//		//Person 객체 받아서 활용
//		Person p = (Person)context.getBean("p1");
//		p.setAge(100);
//		System.out.println(p);
//		
//		Person p2 = context.getBean("p1", Person.class);
//		System.out.println(p2);
//	}
	//step02
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		Person p = (Person)context.getBean("p1");
		p.setAge(100);
		System.out.println(p);
		
		Person p2 = context.getBean("p1", Person.class);
		System.out.println(p2);
	}
	
}
