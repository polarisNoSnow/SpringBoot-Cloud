package com.polaris;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 北辰不落雪
 * @date 2017年11月24日 下午6:51:03
 * @Description
 */
@SpringBootApplication
@RestController
public class ServiceMiyaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceMiyaApplication.class, args);
	}

	private static final Logger LOG = Logger
			.getLogger(ServiceMiyaApplication.class.getName());

	@RequestMapping("/hi")
	public String home() {
		LOG.log(Level.INFO, "hi is being called");
		return "hi i'm miya!";
	}

	@RequestMapping("/miya")
	public String info() {
		LOG.log(Level.INFO, "info is being called");
		return restTemplate.getForObject("http://localhost:8988/info",
				String.class);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
