package com.lz.service;

import com.lz.model.UserBean;

public interface UserService {
	
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	UserBean findUserByNameAndPs(UserBean user);

    /**添加用户
     * @param user
     * @param
     * @return
     */
	int insertUser(UserBean user);
}
