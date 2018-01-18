package com.polaris.bootstrap;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 北辰不落雪 
 * @date 2017年7月11日 上午10:43:24 
 * @Description
 */
@Component
public class ErrorCustomizer implements EmbeddedServletContainerCustomizer{
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/404.html"));
	}

}
