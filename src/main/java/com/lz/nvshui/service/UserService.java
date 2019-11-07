package com.lz.nvshui.service;

import com.lz.nvshui.model.UserBean;

import java.util.List;

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

	/**
	 * 查询全部用户
	 * @param user
	 * @return
	 */
    List<UserBean> selectUsrList(UserBean user);

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int updateUser(UserBean user);

	/**
	 * 删除用户信息
	 * @param user
	 * @return
	 */
	int delUser(UserBean user);
}
