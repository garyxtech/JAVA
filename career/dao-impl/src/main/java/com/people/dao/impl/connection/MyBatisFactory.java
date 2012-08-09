package com.people.dao.impl.connection;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFactory {

	private static SqlSessionFactory sessionFactory;

	public MyBatisFactory() throws IOException {
		sessionFactory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis/mybatis.conf.xml"));
	}

	public SqlSession getNewConnection() {
		return sessionFactory.openSession();
	}
}
