package com.lz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

    private String NO_INTERCEPTOR_PATH = "/views/.jsp/user/test|/user/userLogin|/static/css/login.css|/static/js/login.js|/static/image/火影4.jpg";

    /*
     * 拦截发送的请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;

		/*String servletPath = request.getServletPath();
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
		}*/

    }

    /*
     * 当调用试图解析器之前，调用该方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /*
     * 页面渲染完后，调用，一般用作释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
