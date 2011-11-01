package com.bunker.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bunker.skeleton.domain.User;
import com.bunker.skeleton.service.UserService;

public class Runner {
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/config/beanLocations.xml");

		UserService userService = (UserService) appContext.getBean("userService");

		User user = new User();
		user.setUsername("test");
		userService.save(user);

		User retrievedUser = userService.getUserByUsername("test");

		userService.delete(retrievedUser);
	}
	
}
