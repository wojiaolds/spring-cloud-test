package com.lds.boot.redission.aspect;

import com.lds.boot.redission.annotation.RedisLock;
import com.lds.boot.redission.config.RedissLockUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/8/12 14:32
 */
@Aspect
@Component
public class RedisLockAspect implements InitializingBean {
	
	
	@Autowired
	private RedissLockUtil redissLockUtil;
	
	@Pointcut("@annotation(com.lds.boot.redission.annotation.RedisLock)")
	public void lockPoint(){}
	
	@Before ("lockPoint()")
	public void lock(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature ) joinPoint.getSignature();
		RedisLock redisLock =  signature.getMethod ().getAnnotation (RedisLock.class);
		redissLockUtil.lock (redisLock.key ());
	}
	
	@After ("lockPoint()")
	public void unlock(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature ) joinPoint.getSignature();
		RedisLock redisLock =  signature.getMethod ().getAnnotation (RedisLock.class);
		redissLockUtil.unlock (redisLock.key ());
	}
	
	@Override
	public void afterPropertiesSet () throws Exception {
		System.out.println (123);
	}
}
