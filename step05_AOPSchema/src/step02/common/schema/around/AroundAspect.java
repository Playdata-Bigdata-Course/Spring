package step02.common.schema.around;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAspect {
	//매소드가 before(전처리)/ after&after returning(후처리)/ after throwing
	//return type=Object : 혹 return 데이터가 있는 핵심 메소드라면 공통 해당 로직 실행 후에도 반환값은 핵심 로직을 요청했던 곳으로 넘겨줘야 하기 때문에 OBject 타입으로 리턴 설정
	public Object aroundAspect(ProceedingJoinPoint point) {
		
		//전처리 - before
		System.out.println("[공통 1] 구매를 시작 하실 건가요?");
		
		Object bizReturnValue = null;
		//핵심로직 실행 & 예외
		try {
			bizReturnValue = point.proceed(); //메소드명 무엇이든 무조건 핵심 메소드 호출하는 절대 코드
		} catch (Throwable e) {
			System.out.println("예외발생시 실행");
		}
		
		//후처리 - after/after returning
		System.out.println("[공통 2] 구매를 완료 하셨습니다");
		
		//핵심로직 실행결과 리턴 
		return bizReturnValue;
	}
}
