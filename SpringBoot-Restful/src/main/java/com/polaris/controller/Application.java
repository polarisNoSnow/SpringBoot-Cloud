package com.polaris.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 主启动类
 * @author 北辰不落雪
 *
 */
@SpringBootApplication //same as @EnableAutoConfiguration @Configuration @ComponentScan
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
    }
}
