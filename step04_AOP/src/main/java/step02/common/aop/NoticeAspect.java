package step02.common.aop;

//공통 기능의 클래스
public class NoticeAspect {
	//구맨 전 처리 공통 로직
	public void noticBuyStart() {
		System.out.println("[공통 1] 구매를 시작 하실 건가요?");
	}
	
	//구매 후 처리 공통 로직
	public void noticBuyEnd() {
		System.out.println("[공통 2] 구매를 완료 하셨습니다");
	}
	
}
