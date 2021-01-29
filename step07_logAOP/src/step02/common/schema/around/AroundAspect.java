package step02.common.schema.around;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AroundAspect {
	@Around("within(step01.biz.schema.*)")
	public void around(ProceedingJoinPoint point) {
		log.info("해당 함수 실행 기록");
		log.info("[공통 1 - around] 구매 시작 기록");
		try {
			point.proceed();
		} catch (Throwable e) {
			log.warn("Around 방식으로 예외 처리로직 : " + e.getMessage());
		}
	}
	
	@Before("execution(* step01.biz.schema.*(..))")
	public void startLog() {
		log.info("[공통 1] 구매 시작 기록");
	}
	
	@After("execution(* step01.biz.schema.*(..))")
	public void noticBuyEnd() {
		log.info("[공통 2] 구매 완료 기록");
	}
	
	@AfterReturning(pointcut="execution(* step01.biz.schema.*(..))", returning="value")
	public void noticReturnValue(Object value) {
		log.debug("통일된 방식으로 리턴 처리로직 : " + value);
	}
	
	@AfterThrowing(pointcut="execution(* step01.biz.schema.*(..))", throwing="e")
	public void noticException(Exception e) {
		log.warn("통일된 방식으로 예외 처리로직 : " + e.getMessage());
	}
	
}