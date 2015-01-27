package com.lo.apps.ws.client.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.lo.apps.ws.client")
public class WebConfig extends WebMvcConfigurerAdapter {

	// @Bean
	// public ServletRegistrationBean dispatcherServlet(ApplicationContext
	// applicationContext) {
	// DispatcherServlet servlet = new DispatcherServlet();
	// servlet.setApplicationContext(applicationContext);
	//
	// return new ServletRegistrationBean(servlet, "/*");
	// }

}
