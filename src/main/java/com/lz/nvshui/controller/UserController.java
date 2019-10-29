package com.lz.nvshui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.lz.nvshui.dao.UserDao;
import com.lz.nvshui.model.Menu;
import com.lz.nvshui.model.UserBean;
import com.lz.nvshui.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	
    private static Logger log=LoggerFactory.getLogger(UserController.class);
     
    @Resource
	private UserDao userDao;
    
    @Autowired
    private UserService userService;



	@RequestMapping(value="/rest",method=RequestMethod.GET)
	public String restUrl(HttpServletRequest request, @RequestParam String url){

		return url;
	}

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







	/**查询用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/selectUsrList",method = RequestMethod.POST)
	@ResponseBody
	public List<UserBean>  selectUsrList (UserBean user,HttpServletRequest request, HttpServletResponse response) {
		HashMap remap = new HashMap<String,Object>();
		try {
			List<UserBean> userBean = userService.selectUsrList(user);
			remap.put("data",userBean);
			return userBean;
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			remap.put("msg","查询失败"+e);
			return null;
		}
	}

	/**查询用户
     * @param user
     * @return
     */
    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> userLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody UserBean user) {

		HashMap remap = new HashMap<String,Object>();
		try {
			UserBean reUser = userService.findUserByNameAndPs(user);
			if(reUser != null) {
				//如果登入成功把用户名放入session中
				request.getSession().setAttribute("userLogin", user);
				remap.put("isSuccess",true);
				return remap;
			}else {
				remap.put("isSuccess",false);
				remap.put("msg","你输入的用户或密码不正确");
				return remap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			remap.put("msg","查询失败"+e);
			return remap;
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
}