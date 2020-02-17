package com.yintu.supply.core.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TargetDataSourceAnno {
	DBTypeEnum value() default DBTypeEnum.DB_ONE;
}