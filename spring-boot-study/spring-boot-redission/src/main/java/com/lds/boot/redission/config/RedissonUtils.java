package com.lds.boot.redission.config;

import org.redisson.api.*;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/8/6 14:11
 */
@Component
public class RedissonUtils {
	
	
	/**
	 * 获取字符串对象
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static <T> RBucket<T> getRBucket( RedissonClient redissonClient, String objectName){
		RBucket<T> bucket=redissonClient.getBucket(objectName);
		return bucket;
	}
	
	/**
	 * 获取Map对象
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static <K,V> RMap<K, V> getRMap( RedissonClient redissonClient, String objectName){
		RMap<K, V> map=redissonClient.getMap(objectName);
		return map;
	}
	
	/**
	 * 获取有序集合
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static <V> RSortedSet<V> getRSortedSet( RedissonClient redissonClient, String objectName){
		RSortedSet<V> sortedSet=redissonClient.getSortedSet(objectName);
		return sortedSet;
	}
	
	/**
	 * 获取集合
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static <V> RSet<V> getRSet(RedissonClient redissonClient,String objectName){
		RSet<V> rSet=redissonClient.getSet(objectName);
		return rSet;
	}
	
	/**
	 * 获取列表
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static <V> RList<V> getRList( RedissonClient redissonClient, String objectName){
		RList<V> rList=redissonClient.getList(objectName);
		return rList;
	}
	
	/**
	 * 获取队列
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static <V> RQueue<V> getRQueue(RedissonClient redissonClient,String objectName){
		RQueue<V> rQueue=redissonClient.getQueue(objectName);
		return rQueue;
	}
	
	/**
	 * 获取双端队列
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static <V> RDeque<V> getRDeque(RedissonClient redissonClient,String objectName){
		RDeque<V> rDeque=redissonClient.getDeque(objectName);
		return rDeque;
	}
	
	/**
	 * 获取锁
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static RLock getRLock(RedissonClient redissonClient,String objectName){
		RLock rLock=redissonClient.getLock(objectName);
		return rLock;
	}
	
	/**
	 * 获取原子数
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static RAtomicLong getRAtomicLong(RedissonClient redissonClient,String objectName){
		RAtomicLong rAtomicLong=redissonClient.getAtomicLong(objectName);
		return rAtomicLong;
	}
	
	/**
	 * 获取记数锁
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	
	public static RCountDownLatch getRCountDownLatch(RedissonClient redissonClient,String objectName){
		RCountDownLatch rCountDownLatch=redissonClient.getCountDownLatch(objectName);
		return rCountDownLatch;
	}
	
	/**
	 * 获取消息的Topic
	 * @param redissonClient
	 * @param objectName
	 * @return
	 */
	public static  RTopic getRTopic(RedissonClient redissonClient,String objectName){
		RTopic rTopic=redissonClient.getTopic(objectName);
		return rTopic;
	}
	
	
}

