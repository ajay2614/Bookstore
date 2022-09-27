package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Component
public class LoginDao {

	@Autowired
	@Qualifier(value = "sessionFactory")
	SessionFactory sessionFactory;

	@Transactional("txManager")
	public boolean validate(String userName, String password) {
		try {

			Session s = sessionFactory.openSession();
			Query query = s.createQuery("from User u where u.username=:username and u.password=:password");
			System.out.println("hello");
			query.setParameter("username", userName);
			query.setParameter("password", password);

			User users = (User) query.uniqueResult();
			if (users != null) {
				return true;
			}
		} catch (Exception E) {
			E.printStackTrace();
			return false;
		}
		return false;
	}
}
