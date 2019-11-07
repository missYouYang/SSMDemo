package com.lz.nvshui.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lz.nvshui.dao.UserDao;
import com.lz.nvshui.model.UserBean;
import com.lz.nvshui.service.UserService;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	public UserBean findUserByNameAndPs(UserBean user) {
		UserBean reuser = userDao.findUserByNameAndPs(user);
		System.out.println(reuser);
		return reuser;
	}
	
    /**
	 * 添加用户
     * @param user
     * @param
     * @return
     */
	public int insertUser(UserBean user) {
		user.setCreateUser("admin");
		user.setUserId(UUID.randomUUID().toString());
		int i = userDao.insertUser(user);
		return i;
	}

	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public List<UserBean> selectUsrList(UserBean user) {

		System.out.println(user.getSortOrder());
		List<UserBean> userList = userDao.selectUsrList(user);

		return userList;
	}

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(UserBean user) {

		user.setCreateUser("admin");
		return userDao.updateUser(user);
	}

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public int delUser(UserBean user) {

		user.setCreateUser("admin");
		user.setStatus(-1);
		return userDao.updateUser(user);
	}

}
