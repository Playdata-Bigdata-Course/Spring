package step01.common.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NoticeAspect {
	
	@Before("execution(* step01.biz.annotation.Car.buy*(..))")
	public void noticBuyStart() {
		System.out.println("[공통 1] 구매를 시작 하실 건가요?");
	}
	
	@After("execution(* step01.biz.annotation.Car.buy*(..))")
	public void noticBuyEnd() {
		System.out.println("[공통 2] 구매를 완료 하셨습니다");
	}
	
	@AfterReturning(pointcut="execution(* step01.biz.annotation.Car.*(..))", returning="value")
	public void noticReturnValue(Object value) {
		System.out.println("통일된 방식으로 예외 처리로직:" + value);
	}
	
	@AfterThrowing(pointcut="execution(* step01.biz.annotation.Car.sale*(int))", throwing="e")
	public void noticException(Exception e) {
		System.out.println("통일된 방식으로 예외 처리로직:" + e.getMessage());
	}
}
