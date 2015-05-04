package com.bunker.skeleton.dao.impl;

import java.util.List;

import com.bunker.runner.RoutingContextHolder;
import com.bunker.skeleton.dao.RoutingType;
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
        RoutingContextHolder.setRoutingType(RoutingType.MASTER);
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(User user) {
        RoutingContextHolder.setRoutingType(RoutingType.MASTER);
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public User getById(Long id) {
        RoutingContextHolder.setRoutingType(RoutingType.REPLICA);
		return this.getHibernateTemplate().get(User.class, id);
	}

	@Override
	public User getByUserName(String username) {
        RoutingContextHolder.setRoutingType(RoutingType.REPLICA);
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		List<User> list = getHibernateTemplate().findByCriteria(criteria);
		return list.get(0);
	}

}
