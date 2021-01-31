package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.domain.Customer;

@Controller
public class Step02URITemplate {
	//<a href="urlTest/playdata">
	@RequestMapping("urlTest/{id}")
	public String urlTest(@PathVariable String id ) {
		System.out.println("urlTest()" + id);
		//정상실행 .. url depth가 있는 경우 project명 하위로 설정시 /표기로 해결
		//http://localhost/step09_SpringMVC/step02url.jsp
//		return "redirect:/step02url.jsp"; url 변환확인 불가
		return "forward:/step02url.jsp";
		
		//404
		//http://localhost/step09_SpringMVC/urlTest/playdata
		//http://localhost/step09_SpringMVC/urlTest/step02url.jsp
//		return "redirect:step02url.jsp";
	}
	
	@RequestMapping("urlTest2/{id}/yhj/{age}")
	public String urlTest(@PathVariable String id, @PathVariable int age, @ModelAttribute("id") Customer c) {
		System.out.println("urlTest2()" + id + " " + age);
		System.out.println(c.getId() + " " + c.getAge());
		return "forward:/step02url.jsp";
		
	}
	
}
