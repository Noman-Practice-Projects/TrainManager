package com.topcoder.bullettrain.config;

import com.topcoder.bullettrain.interceptor.GetAllTrainsWithFilterHandler;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GetAllTrainsFilterByInterceptor implements WebMvcConfigurer {
	
	private final GetAllTrainsWithFilterHandler getAllTrainsWithFilterHandler;
	
	public GetAllTrainsFilterByInterceptor(GetAllTrainsWithFilterHandler getAllTrainsWithFilterHandler) {
		this.getAllTrainsWithFilterHandler = getAllTrainsWithFilterHandler;
	}
	
	@Override
	public void addInterceptors(@NonNull InterceptorRegistry registry) {
		registry.addInterceptor(getAllTrainsWithFilterHandler).addPathPatterns("/trains");
	}
}
