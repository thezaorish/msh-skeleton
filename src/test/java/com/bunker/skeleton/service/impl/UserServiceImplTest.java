package com.bunker.skeleton.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bunker.skeleton.dao.UserDao;
import com.bunker.skeleton.domain.User;
import com.bunker.skeleton.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	private UserService userService;

	@Mock
	private UserDao userDao;

	@Before
	public void setUp() {
		this.userService = new UserServiceImpl(userDao);
	}

	@Test
	public void shouldSaveUser() {
		// given
		User user = new User();

		// when
		userService.save(user);

		// then
		verify(userDao).save(user);
	}

	@Test
	public void shouldGetUserByUsername() {
		// given an username
		User user = new User();
		String username = "username";
		given(userService.getUserByUsername(username)).willReturn(user);

		// when
		User retrievedUser = userService.getUserByUsername(username);

		// then
		assertThat(retrievedUser, is(user));
	}

}
