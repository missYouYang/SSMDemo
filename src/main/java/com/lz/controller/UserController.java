package com.lz.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lz.model.User;
import com.lz.service.UserService;
import com.lz.service.impl.UserServiceImpl;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	
    private static Logger log=LoggerFactory.getLogger(UserController.class);
     
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
    public String userLogin(HttpServletRequest request,User user,Model model) {
    	
    	try {
			User reuser = userService.findUserByNameAndPs(user);
			
			if(reuser != null ) {
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
    public String insertUser(User user,Model model) {
    	
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
    
}