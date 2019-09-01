package com.lz.dao;


import java.util.List;

import com.lz.model.Menu;
import com.lz.model.User;

public interface UserDao {
	
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	User findUserByNameAndPs(User user);
	
	int insertUser(User user);

	List<Menu> queryMenuList(Object object);
}
