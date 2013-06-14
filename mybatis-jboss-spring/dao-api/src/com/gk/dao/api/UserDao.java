package com.gk.dao.api;

import com.gk.pojo.User;

public interface UserDao extends BaseDao{

	public User queryUserById(int userId);
	
}
