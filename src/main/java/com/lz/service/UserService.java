package com.lz.service;

import com.lz.model.User;

public interface UserService {
	
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	User findUserByNameAndPs(User user);

    /**添加用户
     * @param user
     * @param model
     * @return
     */
	int insertUser(User user);
}
