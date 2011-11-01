package com.bunker.skeleton.dao.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bunker.skeleton.dao.UserDao;
import com.bunker.skeleton.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/hibernateDaoTest-context.xml")
@Transactional
public class HibernateUserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void shouldSaveUser() {
		// given a configured user
		User user = new User();
		user.setUsername("username");
		
		// when
		userDao.save(user);
		
		// then the user should be persisted
		assertThat(userDao.getById(user.getId()), is(user));
	}
	
	@Test
	public void shouldGetByUsername() {
		// given an existing user
		User user = new User();
		user.setUsername("username");
		userDao.save(user);

		// when
		User retrievedUser = userDao.getByUserName("username");

		// then
		assertThat(retrievedUser, is(user));
	}

	@Test
	public void shouldDeleteUser() {
		// given an existing user
		User user = new User();
		user.setUsername("username");
		userDao.save(user);

		// when
		userDao.delete(user);

		// then the user should be persisted
		assertThat(userDao.getById(user.getId()), nullValue());
	}

}
