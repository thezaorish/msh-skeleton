package com.bunker.skeleton.dao;

import com.bunker.skeleton.domain.User;

public interface UserDao {

	void save(User user);

	User getById(Long id);
	User getByUserName(String username);

	void delete(User user);

}
