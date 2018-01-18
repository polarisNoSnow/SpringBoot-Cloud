package com.polaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 北辰不落雪 
 * @date 2017年11月20日 上午9:44:37 
 * @Description
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication {
	public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }
}
