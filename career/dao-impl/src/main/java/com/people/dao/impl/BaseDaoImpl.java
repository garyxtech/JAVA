package com.people.dao.impl;

import org.apache.ibatis.session.SqlSession;

public class BaseDaoImpl {

	protected SqlSession connection;

	public SqlSession getConnection() {
		return connection;
	}

	public void setConnection(SqlSession connection) {
		this.connection = connection;
	}

}
