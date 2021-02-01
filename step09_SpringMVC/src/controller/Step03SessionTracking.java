package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.domain.Customer;

//다수의 공통된 요청하는 url을 일괄 설정
@Controller
@RequestMapping("sessiontracking")
//세션에서 사용하고자 하는 key명들을 명시적으로 선언 
@SessionAttributes({"id" , "age",  "cust"})
public class Step03SessionTracking {
	
	/*	쿠키 정보를 spring에서 활용 가능한 기술
	 *	Cookie c = new Cookie("id", "cookieData"); 이미 id로 cookieData를 client 시스템에 저장되어 있는 상태
	 */
	//<a href="sessiontracking/sessionTest">
	@RequestMapping("/cookietest")
	public String m1(@CookieValue("id") String idValue) {
		System.out.println("m1()" + idValue);
		return "redirect:/step03cookieView.jsp";
	}
	
	/*	Spring controller 개발시에 servlet api 활용 가능
	 * 	세션은 HttpSession API 사용시 이 API로 일관성 있게 활용
	 * 애노테이션 기반으로 세션 개발 하실거라면 일관성 있게 애노테이션
	 * 즉 스프링 코드에 맞게 개발 권장
	 */
	
	//HttpSession API로 개발 할 경우
	@RequestMapping("/sessionTest1")
	public String m2(HttpSession session) {
		System.out.println("m2()" + session.getAttribute("id"));
		session.setAttribute("newData", "fuck");
		return "redirect:/step03Session1.jsp";
	}
	
	//실습 순서 : step03.jsp -> controller -> step03Session1.jsp -> controller의 m3()
	//세션 삭제
	//sessionDelet url
	@RequestMapping("/sessionDelete")
	public String m3(HttpSession session) {
		System.out.println("m3()");
		session.invalidate();
		session = null;
		return "redirect:/step03Session1.jsp";
	}
	
	/*	step03.jsp에서 세션에 저장한 데이터 값을 spring 스펙으로 활용 		
	 * 	step03 단계의 세션 코드 관점
	 * 	@SessionAttributes({"id", "age"}) 선언으로 인해 
	 * 		@ModelAttribute는 Session의 데이터 활용하는 기능으로 쓰임
	 * 
	 * 	@ModelAttribute("id") String id
	 * 	-HttpSession 객체로 부터 getAttribute("id")
	 * 		HttpSession session = request.getSession
	 * 		String id = (String)Session.getAttribute("id")
	 */
	//<a href="sessiontracking/sessionTest2">2-2. @SessionAttributes 이해하기 </a>
	@RequestMapping("sessionTest2")
	public String m4(@ModelAttribute("id") String id, @ModelAttribute("age") int age) {
		System.out.println("m4()" + id + " " + age);
		return "redirect:/step03Session1.jsp";
	}
	
	//SessionAttributes()로 선언한 세션 데이터 소멸 기술
	@RequestMapping("sessionDelete2")
	public String m5(SessionStatus status) {
		System.out.println("m5()");
		status.setComplete();
		return "redirect:/step03Session1.jsp";
	}
	
	/*	id와 age를 web query string 으로 전송
	 * SessionAttributes()로 "cust"별칭등록
	 * Model 객체에 addAttribute("cust", Customer객체)
	 * View단 : ${SessionScope.cust.id} 사용
	 * 
	 * Model API - request 또는 session 모두에서 사용
	 * 단, @SessionAttributes({"id","age,"cust"}) 선언되어 있으면서
	 * 선언된 key로 model.addAttribute("cust", cust)로 처리할 경우엔 세션 객체에 저장되는 구조
	 */
	//sessionTest3DTO
	//view에서 활용 : ${SessionScope.cust.id}
	@RequestMapping("sessionTest3DTO")
	public String m6(Model model, Customer cust) {
		System.out.println("m6()" + cust.getId());
		//SessionAttributes({"cust"}) 로 선언되어 있기 때문에 Model은 세션의 데이터로 간주
		model.addAttribute("cust", cust);
		return "redirect:/step03Session1.jsp";
	}
}
