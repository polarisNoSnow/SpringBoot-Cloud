package com.polaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * @author 北辰不落雪 
 * @date 2017年11月24日 上午11:03:54 
 * @Description
 */
@SpringBootApplication
@EnableZipkinServer  //开启ZipkinServer
public class ServerZipkinApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
