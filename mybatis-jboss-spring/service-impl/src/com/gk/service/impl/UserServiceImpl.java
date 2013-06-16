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
	public void insertAdmin() throws Exception {
		User admin = new User();
		admin.setFirstName("ADMIN");
		admin.setLastName("ADMIN");
		insertUser(admin);
	}

	@Override
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
	public void insertF1F2AndThenADMIN() throws Exception {

		insertF1F2();

		insertAdmin();

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void testTransaction() throws Exception {
		User user = new User();
		user.setFirstName("F1");
		user.setLastName("L1");
		userDao().insertUser(user);

		user.setFirstName("F2");
		user.setLastName("L2");
		userDao().insertUser(user);

		long time = System.currentTimeMillis();
		System.out.println("time is " + time);
		if (time % 2 >= 0) {
			;// throw new Exception("Rollback this time");
		}

		user.setFirstName("F3");
		user.setLastName("L3");
		userDao().insertUser(user);

		user.setFirstName("F4");
		user.setLastName("L4");
		userDao().insertUser(user);
	}

	@Override
	public void testPureJdbcSql() throws Exception {
		userDao().insertDummyUserWithPureJdbcSql();
	}

}
