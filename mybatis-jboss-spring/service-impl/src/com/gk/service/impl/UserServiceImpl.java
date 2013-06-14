package com.gk.service.impl;

import com.gk.dao.api.UserDao;
import com.gk.pojo.User;
import com.gk.service.api.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public User getUserById(int id) {
		return daoCenter.getDao(UserDao.class).queryUserById(id);
	}

}
