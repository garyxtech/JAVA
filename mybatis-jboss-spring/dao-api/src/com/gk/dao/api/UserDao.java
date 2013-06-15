package com.gk.dao.api;

import java.util.List;

import com.gk.pojo.User;

public interface UserDao extends BaseDao {

	public User queryUserById(int userId);

	public void insertUser(User user) throws Exception;

	public void createTable();

	public List<User> fetchAllUsers();

}
