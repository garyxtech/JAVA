package com.gk.dao.impl;

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

}
