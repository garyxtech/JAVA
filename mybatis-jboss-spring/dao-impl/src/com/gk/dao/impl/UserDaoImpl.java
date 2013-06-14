package com.gk.dao.impl;

import com.gk.dao.api.UserDao;
import com.gk.pojo.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User queryUserById(int userId) {
		User user = new User();
		user.setFirstName("Gary");
		user.setLastName("Xue");
		return user;
	}

}
