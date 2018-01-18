package com.polaris.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 * @author 北辰不落雪 
 * @date 2017年11月16日 上午10:51:56 
 * @Description
 */
@SpringBootApplication(scanBasePackages={"com.polaris"}) //默认扫描当前包及子包，http://blog.csdn.net/l1h2l3/article/details/73484806
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix //开启断路器
@EnableHystrixDashboard //开启仪表盘
@EnableCircuitBreaker //开启断路器的使用（ribbon中不需要）
@RestController
public class ServiceFeginApplication {
	public static void main(String[] args) {
        SpringApplication.run(ServiceFeginApplication.class, args);
    }
	
	@Value("${server.port}")
    String port;
    @RequestMapping("/hi2")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
