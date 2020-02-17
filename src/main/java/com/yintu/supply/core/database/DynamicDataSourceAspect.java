package com.yintu.supply.core.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DynamicDataSourceAspect {

	@Around("@annotation(targetDataSourceAnno)")
	public Object aroundOperDeal(ProceedingJoinPoint pjp, TargetDataSourceAnno targetDataSourceAnno) throws Throwable {
		DBContextHolder.setDBType(targetDataSourceAnno.value());
		Object retVal = pjp.proceed();
		DBContextHolder.clearDBType();
		return retVal;
	}
}