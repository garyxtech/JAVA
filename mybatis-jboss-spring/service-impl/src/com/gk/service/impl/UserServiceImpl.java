package com.gk.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.api.UserDao;
import com.gk.pojo.User;
import com.gk.service.api.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	private UserDao userDao() {
		return daoCenter.getDao(UserDao.class);
	}

	@Override
	public void createUserTable() {
		userDao().createTable();
	}

	@Override
	public List<User> fetchAllUsers() {
		return userDao().fetchAllUsers();
	}

	@Override
	public void insertUser(User user) throws Exception {
		userDao().insertUser(user);
	}

	@Override
	@Transactional
	public void insertAdmin() throws Exception {
		User admin = new User();
		admin.setFirstName("ADMIN");
		admin.setLastName("ADMIN");
		insertUser(admin);
	}

	@Override
	@Transactional
	public void insertF1F2() throws Exception {

		User user = new User();
		user.setFirstName("F1");
		user.setLastName("L2");
		insertUser(user);

		user.setFirstName("F2");
		user.setLastName("L2");
		insertUser(user);
	}

	@Override
	@Transactional
	public void insertAdminAndF1F2() throws Exception {

		insertF1F2();

		insertAdmin();

	}

}
