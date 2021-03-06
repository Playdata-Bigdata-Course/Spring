package step01.biz.schema;

import org.springframework.stereotype.Component;

//구매, 판매 로직의 핵심 기능이라 가정
@Component("car")
public class Car {
	public void buy() {
		System.out.println("자동차 구매"); 					//biz logic
	}
	
	public void buyMoney(int money) {
		System.out.println("자동차 구입한 금액 " + money); 		//biz logic
	}

	public void buy2() {
		System.out.println("자동차 구매");
	}
	
	public void buyMoney2(int money) {
		System.out.println("자동차 구입한 금액 " + money);
	}
	
	public String buyReturn() {
		return "자동차 구매 성공";
	}
	
	//판매 금액이 1000만원 이하인 경우에 예외 발생
	public void saleMoney(int money) throws Exception {
		if(money <= 1000) {
			throw new Exception("너무 싸!!!"); //getMessage()로 내용확인
		}
	}
}
