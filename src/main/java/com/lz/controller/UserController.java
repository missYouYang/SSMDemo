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
    
    @RequestMapping(value="/test",method=RequestMethod.GET)  
    public String test(HttpServletRequest request,Model model){  
        String userId = request.getParameter("id");  
        User user = userService.findUserById(userId);
        log.debug(user.toString());
        model.addAttribute("user", user);  
        return "index";  
    }  
}