package com.lds.boot.rediscache.service.impl;

import com.lds.boot.rediscache.dao.UserRepository;
import com.lds.boot.rediscache.entity.User;
import com.lds.boot.rediscache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * user service implement
 * @author louie
 * @date created in 2018-12-3 23:33
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl (UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * save use, put redis cache
	 * @param user user data
	 * @return saved user data
	 */
	@Override
	@CachePut(value = "user", key = "#result.id", unless = "#result eq null")
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * find user by id,redis cacheable
	 * @param userId user id
	 * @return if exist return the user, else return null
	 */
	@Override
	@Cacheable(value = "user", key = "#userId", unless = "#result eq null")
	public User findUser(String userId) {
		return userRepository.findById(userId).orElse(null);
	}

	/**
	 * delete user by id, and remove redis cache
	 * @param userId user id
	 */
	@Override
	@CacheEvict(value = "user", key = "#userId")
	public void deleteUser(String userId) {
		userRepository.findById(userId).ifPresent(userRepository::delete);
	}
}
