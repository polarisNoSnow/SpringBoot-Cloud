package com.polaris;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 北辰不落雪
 * @date 2017年11月28日 上午11:22:51
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulMiyaApplication {

	public static void main(String[] args) {
		/*new SpringApplicationBuilder(ConsulMiyaApplication.class).web(true)
				.run(args);*/
		String x="10:02";
		if(x.length() == 2){
			x+=":00:00";
		}
		if(x.length() == 4){
			x+=":00";
		}
		System.out.println("10:00:02".compareTo(x));
	}
	
	@RequestMapping("/hi")
	public String home() {
		return "hi ,i'm miya";
	}
	
}
