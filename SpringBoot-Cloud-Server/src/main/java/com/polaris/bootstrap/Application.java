package com.polaris.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主启动类
 * 
 * @author 北辰不落雪
 *
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
// same as @EnableAutoConfiguration @Configuration @ComponentScan
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		// dubbo方式
		// TestRegistryService bean = run.getBean(TestRegistryService.class);
		// System.out.println(bean.sayHello("tyb"));
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi " + name + ",i am from port:" + port;
	}
	
	
}
