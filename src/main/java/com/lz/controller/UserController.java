package com.lz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lz.dao.UserDao;
import com.lz.model.Menu;
import com.lz.model.UserBean;
import com.lz.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	
    private static Logger log=LoggerFactory.getLogger(UserController.class);
     
    @Resource
	private UserDao userDao;
    
    @Autowired
    private UserService userService;
    
    /**
     * 原始界面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/test",method=RequestMethod.GET)  
    public String test(HttpServletRequest request,Model model){  
        return "login";  
    }  
    
    /**查询用户
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request, UserBean user, Model model) {
    	
    	try {
			UserBean reuser = userService.findUserByNameAndPs(user);
			
			if(reuser != null) {
				model.addAttribute("message", "登入成功");
				//如果登入成功把用户名放入session中
				request.getSession().setAttribute("userLogin", user);
				return "tinHeart";
			}else {
				model.addAttribute("message", "你输入的用户或密码不正确");
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "访问出现异常");
			return "login";
		}
	
    	
    }
    
    /**添加用户
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value="/insertUser",method = RequestMethod.POST)
    public String insertUser(UserBean user, Model model) {
    	
    	try {
			int i = userService.insertUser(user);
			if(i == 1 ) {
				return "login";
			}else {
				model.addAttribute("message", "注册失败");
				return "register";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "访问出现异常");
			return "register";
		}
    }
    
    /**递归多级菜单练习
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value="/queryMenuList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> test(Map<String,Object> map,Model model) {
    	
    	
    	// 原始的数据
    	List<Menu> rootMenu = userDao.queryMenuList(null);
    	// 查看结果
    	for (Menu menu : rootMenu) {
    		System.out.println(menu);
    	}
    	// 最后的结果
    	List<Menu> menuList = new ArrayList<Menu>();
    	// 先找到所有的一级菜单
    	for (int i = 0; i < rootMenu.size(); i++) {
    		// 一级菜单没有parentId
    		if (StringUtils.isBlank(rootMenu.get(i).getParentId())) {
    			menuList.add(rootMenu.get(i));
    		}
    	}
    	// 为一级菜单设置子菜单，getChild是递归调用的
    	for (Menu menu : menuList) {
    		menu.setChildMenus(getChild(menu.getId(), rootMenu));
    		}
    		Map<String,Object> jsonMap = new HashMap<>();
    		jsonMap.put("menu", menuList);
    		System.out.println(jsonMap);
			return jsonMap;
    	}



       /*递归练习*/
    	private List<Menu> getChild(String id, List<Menu> rootMenu) {
    		// 子菜单
    		List<Menu> childList = new ArrayList<>();
    		for (Menu menu : rootMenu) {
    			// 遍历所有节点，将父菜单id与传过来的id比较
    			if (StringUtils.isNotBlank(menu.getParentId())) {
    				if (menu.getParentId().equals(id)) {
    					childList.add(menu);
    				}
    			}
    		}
    		// 把子菜单的子菜单再循环一遍
    		for (Menu menu : childList) {// 没有url子菜单还有子菜单
    			if (StringUtils.isBlank(menu.getUrl())) {
    				// 递归
    				menu.setChildMenus(getChild(menu.getId(), rootMenu));
    			}
    		} // 递归退出条件
    		if (childList.size() == 0) {
    			return null;
    		}
    		return childList;
    }
    
    
}