package com.lds.boot.redission.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: lds
 * @Date: 2019/8/12 14:25
 */
@Retention ( RetentionPolicy.RUNTIME)
@Target ( ElementType.METHOD)
public @interface RedisLock {
	String key() default "";
}
