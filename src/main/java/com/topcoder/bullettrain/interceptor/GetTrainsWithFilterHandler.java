package com.topcoder.bullettrain.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetTrainsWithFilterHandler implements HandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String[] amenities = request.getParameterValues("amenities");
		if (amenities != null) {
			response.sendRedirect("/");
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
