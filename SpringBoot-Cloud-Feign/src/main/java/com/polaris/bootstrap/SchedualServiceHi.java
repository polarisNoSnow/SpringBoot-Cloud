package com.polaris.bootstrap;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 北辰不落雪 
 * @date 2017年11月16日 下午2:41:58 
 * @Description
 */
@Component //向 Spring Boot 中注入该组件
@FeignClient(value = "eureka-server-hi",fallback = SchedualServiceHiHystric.class) //绑定该接口对应的服务
public interface SchedualServiceHi {
	
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
