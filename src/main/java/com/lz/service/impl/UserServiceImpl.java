package com.lz.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lz.dao.UserDao;
import com.lz.model.UserBean;
import com.lz.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	@Override
	public UserBean findUserByNameAndPs(UserBean user) {
		UserBean reuser = userDao.findUserByNameAndPs(user);
		System.out.println(reuser);
		return reuser;
	}
	
    /**添加用户
     * @param user
     * @param
     * @return
     */
	@Override
	public int insertUser(UserBean user) {
		int i = userDao.insertUser(user);
		return i;
	}
	
}
