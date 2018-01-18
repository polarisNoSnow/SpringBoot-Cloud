package com.polaris.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 北辰不落雪 
 * @date 2017年11月9日 下午7:51:24 
 * @Description
 */

/**
 * 该注解表明应用为eureka服务，有可以联合多个服务作为集群，对外提供服务注册以及发现功能
 * @author 北辰不落雪 
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication {
	public static void main(String[] args) {
		//new SpringApplicationBuilder(EurekaserverApplication.class).web(true).run(args);
		SpringApplication.run(EurekaserverApplication.class, args);
	}
}
