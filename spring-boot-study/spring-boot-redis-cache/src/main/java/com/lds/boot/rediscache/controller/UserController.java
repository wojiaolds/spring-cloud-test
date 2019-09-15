package com.lds.boot.rediscache.controller;


import com.lds.boot.rediscache.entity.User;
import com.lds.boot.rediscache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * user controller
 * @author louie
 * @date created in 2018-12-3 23:25
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
	private final UserService userService;

	public UserController (UserService userService) {
		this.userService = userService;
	}

	@RequestMapping
	public User saveUser( User user) {
		log.info("插入用户信息：{}",user);
		return userService.save(user);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = userService.findUser(userId);
		HttpStatus status = user == null ? HttpStatus.NOT_FOUND: HttpStatus.OK;
		return new ResponseEntity<>(user, status);
	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
