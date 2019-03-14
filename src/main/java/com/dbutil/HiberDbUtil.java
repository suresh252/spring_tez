package com.dbutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberDbUtil {
	private static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		Configuration configure = new Configuration().configure();
		sessionFactory = configure.buildSessionFactory();
		return sessionFactory;
	}
}
