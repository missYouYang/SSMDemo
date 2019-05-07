package com.lz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lz.model.User;

public interface UserDao {
	User findUserById(String id);
	
	int insertUser(User user);
}
