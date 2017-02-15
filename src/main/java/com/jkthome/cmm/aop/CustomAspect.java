package com.jkthome.cmm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {
	protected static final Logger logger = LoggerFactory.getLogger(CustomAspect.class);

	@Pointcut("execution(public * com.jkthome..*Controller.*(..))")
	public void pointcut() {}
	
	/**
	 * @Method 설명 : 사용자 Aop 예제
	 * @param jointPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("pointcut()")
	public Object customCheck(ProceedingJoinPoint jointPoint) throws Throwable {
		logger.info("**aop proceed** custom check method path : {}", jointPoint.getSignature());
		
		return jointPoint.proceed();
	}
	
	
	 /**
     * annotation을 이용한 Aop 예제
     * @param joinPoint
     */
    @Before("@annotation(com.jkthome.cmm.annotation.AnnotationCheck)")
    public void loggingAdvice2(JoinPoint jointPoint) {
        logger.info("**before** annotation method path : {}", jointPoint.getSignature());
    }
}