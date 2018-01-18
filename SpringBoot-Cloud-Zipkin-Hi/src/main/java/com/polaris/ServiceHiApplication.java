package com.polaris;

import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 北辰不落雪
 * @date 2017年11月24日 上午11:16:07
 * @Description
 */
@SpringBootApplication
@RestController
public class ServiceHiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(ServiceHiApplication.class);

	@Autowired
	// byTYPE（@Autowired）、byNAME（@Resource）
	private RestTemplate restTemplate;

	@Bean
	// 告诉Spring容器，你可以从下面这个方法中拿到一个Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome() {
		log.log(Level.INFO, "calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8989/miya",String.class);
	}

	@RequestMapping("/info")
	public String info() {
		log.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";

	}
	
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
