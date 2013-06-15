package com.gk.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.gk.dao.api.BaseDao;

public abstract class BaseDaoImpl implements BaseDao {

	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
