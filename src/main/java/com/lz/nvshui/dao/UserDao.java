package com.lz.nvshui.dao;


import java.util.List;

import com.lz.nvshui.model.Menu;
import com.lz.nvshui.model.UserBean;

public interface UserDao {

	UserBean findUserByNameAndPs(UserBean user);
	
	int insertUser(UserBean user);

	List<Menu> queryMenuList(Object object);

    List<UserBean> selectUsrList(UserBean user);

    int updateUser(UserBean user);

}
