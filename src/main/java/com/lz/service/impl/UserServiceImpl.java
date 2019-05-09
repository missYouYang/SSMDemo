package com.lz.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lz.dao.UserDao;
import com.lz.model.User;
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
	public User findUserByNameAndPs(User user) {
		User reuser = userDao.findUserByNameAndPs(user);
		return reuser;
	}
	
    /**添加用户
     * @param user
     * @param model
     * @return
     */
	@Override
	public int insertUser(User user) {
		int i = userDao.insertUser(user);
		return i;
	}
	
}
