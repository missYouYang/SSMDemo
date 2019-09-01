package com.lz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lz.util.RedisUtil;

@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private RedisUtil redisUtil;
	
	@RequestMapping(value="/redisget",method = RequestMethod.POST)
	public void getRedis() {
		
		String string = redisUtil.get("a");
		
		System.out.println(string);
		
	}
}
