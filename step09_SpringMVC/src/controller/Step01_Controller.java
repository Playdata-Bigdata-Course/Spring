package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.domain.Customer;

@Controller
public class Step01_Controller {
	//<a href="hello1"> -> controller -> step01RedirectView.jsp
	@RequestMapping("hello1")
	public String m1() {
		System.out.println("m1()");
		return "redirect:step01RedirectView.jsp";
	}
	
	//<a href="hello2">
	@RequestMapping("hello2")
	public ModelAndView m2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("newData", "느그권");
		mv.setViewName("view/step01hello2");
		return mv; //forward 방식으로 view로 이동
	}
	
	//<a href="hello3">
	@RequestMapping("hello3")
	public String m3() throws Exception{
		System.out.println("m3()");
		if(true) {
			throw new Exception("예외처리학습");
		}
		return null;
	}
	
	//예외 전담 처리 메소드 - exception handling 메소드
	//예외 타입 설정 - Exception 타입으로 test
	@ExceptionHandler
	public String handler(Exception e) {
		System.out.println("handler()");
		System.out.println(e.getMessage());
		return "redirect:failView.jsp";
	}
	
   @RequestMapping("hello4")
   public String m4(RedirectAttributes attr){
      System.out.println("m4");
    //web querystring 구성과 동일
  	//request.getParameter("newData") or ${param.newData}
      attr.addAttribute("newData", "redirect이동시 전송된 데이터");
      //step01hello4.jsp?newData=redirect data
      return "redirect:step01hello4.jsp";
   }
   
   /*@RequestParam("id") String id
    *String id = request.getParameter("id);
    *
    * @RequestParam("age") int age
    *int age = Integer.parseInt(requset.getParameter("age)) 
    *
    *결론 : request 객체 내에 저장된 web query String
    */
   //<a href="hello5?id=tester&age=10">
   @RequestMapping("hello5")
   public ModelAndView  m5(@RequestParam("id") String id, @RequestParam("age") int age) {
	   System.out.println("m5() - " + id + age);
	   ModelAndView mv = new ModelAndView();
	   mv.addObject("newData", "m5() save"); //request.setAttribute()
	   mv.setViewName("view/step01hello5");
	   return mv; //request객체가 유지되면서 화면이동
   }
   
   /*	contorller의 메소드 parameter로 dto 선언 시
    *  	-client라 전송하는 web query string key와 일치되는 변수들을 보유한 DTO인 경우 자동생성
    * 	-?id=tester&age=100 => Customer에도 id와 age변수 와 setXxx()필수
    */
   //<a href="hello6?id=tester&age=100">
   @RequestMapping("hello6")
   public String m6(Customer cust) {
	   System.out.println("m6()" + cust.getId());
	   
	   //forward방식으로 viewResolver를 통해서 웹 페이지 이동
	   return "view/step01hello6"; //forward, WEB-INF/view/step01hello6.jsp
   }
   
   /*	Model
    * 	1. 이름처럼 데이터 표현용 API
    * 	2. org.springframework.ui.Model package명에서 짐작
    * 		- 화면 처리단에서 사용된 데이터 활용 API
    */
   //<a href="hello7?id=tester&age=100">
   @RequestMapping("hello7")
   public String m7(Model model) {
	   System.out.println("m7()");
	   model.addAttribute("newData", "playdata");
	   return "view/step01hello7"; 
   }
   
   /*@ModelAttribute("cust") Customer c
    * Customer 객체 생성 : Customer c =new Customer(request.getParameter("id"), Integer.parseInt(equest.getParameter("id"));
    * request.setAttribute("cust",c);
    */
   //<a href="hello8?id=tester&age=70">
   @RequestMapping("hello8")
   public String m8(@ModelAttribute("cust") Customer c) {
	   System.out.println("m8()" + c.getId());
	   return "view/step01hello8";
   }
   
}