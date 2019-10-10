package com.lz.dao;


import java.util.List;

import com.lz.model.Menu;
import com.lz.model.UserBean;

public interface UserDao {
	
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	UserBean findUserByNameAndPs(UserBean user);
	
	int insertUser(UserBean user);

	List<Menu> queryMenuList(Object object);
}
