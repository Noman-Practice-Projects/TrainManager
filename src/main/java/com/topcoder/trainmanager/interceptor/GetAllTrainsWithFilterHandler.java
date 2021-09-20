package com.topcoder.trainmanager.interceptor;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GetAllTrainsWithFilterHandler extends InterceptorRegistry implements HandlerInterceptor {
	
	private final Logger LOG = LoggerFactory.getLogger(GetAllTrainsWithFilterHandler.class.getName());
	
	@Override
	public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
		LOG.info("pre handle " + request.getRequestURI());
		String[] amenities = request.getParameterValues("amenities");
		if (amenities != null) {
			String amenityEndpoint = request.getRequestURI() + "/amenity";
			LOG.info("Found amenities in the query parameters. Redirecting to " + amenityEndpoint);
			response.sendRedirect(amenityEndpoint + "?keyword=" + amenities[0]);
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
