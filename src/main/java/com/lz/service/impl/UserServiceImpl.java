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

	public User findUserById(String id) {
		
		User user = userDao.findUserById(id);
		
		return user;
	}
	
}
