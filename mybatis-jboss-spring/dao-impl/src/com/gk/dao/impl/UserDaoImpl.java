package com.gk.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gk.dao.api.UserDao;
import com.gk.pojo.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User queryUserById(int userId) {

		User user = getSqlSession().selectOne(
				UserDao.class.getName() + ".queryUserById", userId);

		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {

		if (user.getFirstName().equals("ADMIN")) {
			for (User u : fetchAllUsers()) {
				if ("ADMIN".equalsIgnoreCase(u.getFirstName())) {
					throw new Exception("Data Access: ADMIN already exists");
				}
			}
		}

		getSqlSession().insert(UserDao.class.getName() + ".insertUser", user);
	}

	@Override
	public void createTable() {
		getSqlSession().update(UserDao.class.getName() + ".createTable");
	}

	@Override
	public List<User> fetchAllUsers() {
		return getSqlSession().selectList(
				UserDao.class.getName() + ".fetchAllUsers");
	}

	@Override
	public void insertDummyUserWithPureJdbcSql() throws SQLException {
		Connection conn = getSessionFactory().openSession().getConnection();

		try {
			conn.createStatement().execute(
					"insert into TBL_USR (firstName, lastName) "
							+ "values ('DMY_FN', 'DMY_LN')");
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			throw ex;
		} finally {
			conn.close();
		}
	}

}
