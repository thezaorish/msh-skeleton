package com.bunker.skeleton.service;

import com.bunker.skeleton.domain.User;

public interface UserService {

	void save(User user);

	User getUserByUsername(String username);

	void delete(User user);

}
