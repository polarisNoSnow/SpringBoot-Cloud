package com.polaris;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 北辰不落雪 
 * @date 2017年11月21日 下午8:18:59 
 * @Description
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope //自动更新配置变量
public class ConfigClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${name}")
	private String name;
	
	@Value("${spring.cloud.config.discovery.serviceId}")
	private String uri;
	
	@RequestMapping(value = "/hi")
	public String hi(){
		return uri+":"+name;
	}
	
}
