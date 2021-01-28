package running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.domain.Dept;
import model.domain.Emp;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("playdata.xml");
		
		Emp emp1 = context.getBean("emp", Emp.class);
		emp1.setEname("무야호");
		emp1.setEmpno(99);
		emp1.getDept();
		emp1.setDept(new Dept(1,"앵커리지한인회관", "알레스카"));
		
		
		System.out.println(emp1); 			
		System.out.println(emp1.getDept()); 
		
	}
}