package step01.common.schema;

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
	
	//반환시 공통로직
	/* 설계 - 메소드가 반환하는 로직을 포함한 경우에 공통적으로 처리하고자 하는 로직
	 * parameter로 핵심 로직이 반환하는 값을 받아서 처리
	 * 핵심로직이 반환하는 타입의 수는 무한대를 수용 가능하게 하려면 어떤 타입으로 parameter로 처리
	 */
	public void noticReturnValue(Object value) {
		System.out.println("통일된 방식으로 예외 처리로직:" + value);
	}
	
	//예외발생시 실행되는 공통로직
	/* 핵심로직 실행시 발생되는 예외를 일괄적으로 받아서 처리
	 * 설계 - parameter로 발생되는 예외를 받아서 처리
	 */
	public void noticException(Exception e) {
		System.out.println("통일된 방식으로 예외 처리로직:" + e.getMessage());
	}
}
