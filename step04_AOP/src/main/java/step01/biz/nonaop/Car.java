package step01.biz.nonaop;

import step01.common.nonaop.NoticeAspect;

//구매, 판매 로직의 핵심 기능이라 가정
public class Car {
	//step01
	//구매
	public void buy() {
		System.out.println("[공통 1] 구매를 시작 하실 건가요?");  	//공통로직
		System.out.println("자동차 구매"); 					//biz logic
		System.out.println("[공통 2] 구매를 완료 하셨습니다");
	}
	
	public void buyMoney(int money) {
		System.out.println("[공통 1] 구매를 시작 하실 건가요?"); 	//공통로직
		System.out.println("자동차 구입한 금액 " + money); 		//biz logic
		System.out.println("[공통 2] 구매를 완료 하셨습니다");
	}
	
	public void buy2() {
		NoticeAspect.noticBuyStart();
		System.out.println("자동차 구매");
		NoticeAspect.noticBuyEnd();
	}
	
	public void buyMoney2(int money) {
		NoticeAspect.noticBuyStart();
		System.out.println("자동차 구입한 금액 " + money);
		NoticeAspect.noticBuyEnd();
	}
	
	
	public String buyReturn() {
		return "자동차 구매 성공";
	}
	
	//판매 금액이 1000만원 이하인 경우에 예외 발생
	public void saleMoney(int money) throws Exception {
		if(money <= 1000) {
			throw new Exception("너무 싸!!!");
		}
	}
}
