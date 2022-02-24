package com.kh.team1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kh.team1.account.model.AccountDTO;

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("logined") == null || 
				session.getAttribute("account") == null) {
			if(request.getHeader("Accept").contains("application/json")) {
				response.setContentType("application/json; charset=UTF-8");
				JSONObject json = new JSONObject();
				json.put("state", "redirect");
				json.put("url", "/login?next=" +
						request.getParameter("next") +
						"?dno=" + request.getParameter("dno"));
				response.getWriter().print(json.toJSONString());
			} else {
				response.sendRedirect("/login?next=" + request.getRequestURI());
			}
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Interceptor postHandle run!");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Interceptor afterHandle run!");
	}

}
