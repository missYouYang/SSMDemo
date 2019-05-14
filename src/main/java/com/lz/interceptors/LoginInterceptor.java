package com.lz.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	private String NO_INTERCEPTOR_PATH = "/user/test|/user/userLogin|/static/css/login.css|/static/js/login.js|/static/image/火影4.jpg";
	
	/*
	 * 拦截发送的请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String servletPath = request.getServletPath();
		if(NO_INTERCEPTOR_PATH.contains(servletPath)) {
			return true;
		}else {
			Object attribute = request.getSession().getAttribute("userLogin");
			if(attribute != null) {
				return true;
			}else {
				response.sendRedirect(request.getContextPath() + "/user/test");
				return false;
			}
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
