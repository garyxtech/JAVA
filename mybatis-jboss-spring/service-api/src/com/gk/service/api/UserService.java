package com.gk.service.api;

import java.util.List;

import com.gk.pojo.User;

public interface UserService extends BaseService {

	public void createUserTable();

	public List<User> fetchAllUsers();

	public void insertUser(User user) throws Exception;

	public void insertAdmin() throws Exception;

	public void insertF1F2AndThenADMIN() throws Exception;

	public void insertF1F2() throws Exception;

	public void testTransaction() throws Exception;
	
	public void testPureJdbcSql() throws Exception;

}
