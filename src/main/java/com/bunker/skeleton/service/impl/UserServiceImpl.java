package com.bunker.skeleton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bunker.skeleton.dao.UserDao;
import com.bunker.skeleton.domain.User;
import com.bunker.skeleton.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void save(User user) {
		this.userDao.save(user);
	}
	
	@Override
	public void delete(User user) {
		this.userDao.delete(user);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return this.userDao.getByUserName(username);
	}
	
}
