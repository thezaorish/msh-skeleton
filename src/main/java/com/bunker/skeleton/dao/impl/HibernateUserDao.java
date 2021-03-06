package com.bunker.skeleton.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bunker.skeleton.dao.UserDao;
import com.bunker.skeleton.domain.User;

@Repository("userDao")
public class HibernateUserDao extends HibernateDaoSupport implements UserDao {

	@Autowired
	public HibernateUserDao(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public User getById(Long id) {
		return this.getHibernateTemplate().get(User.class, id);
	}

	@Override
	public User getByUserName(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		List<User> list = getHibernateTemplate().findByCriteria(criteria);
		return list.get(0);
	}

}
