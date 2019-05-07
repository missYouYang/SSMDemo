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
		
		
		User user2 = new User();
		user2.setId("8");
		user2.setUserName("xiaohong");
		user2.setPassword("123");
		user2.setAge(22);
		userDao.insertUser(user2);
		
		int i = 1/0;
		
		User user3 = new User();
		user3.setId("9");
		user3.setUserName("xiaowu");
		user3.setPassword("123");
		user3.setAge(22);
		userDao.insertUser(user3);
		
		
		
		return user;
	}
	
}
