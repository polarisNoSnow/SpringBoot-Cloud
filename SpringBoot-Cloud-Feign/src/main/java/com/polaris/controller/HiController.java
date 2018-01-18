package com.polaris.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.bootstrap.SchedualServiceHi;

/**
 * @author 北辰不落雪
 * @date 2017年11月16日 下午2:45:57
 * @Description
 */
@RestController
public class HiController {
	
	//@Lazy             //延迟加载。否则项目启动就会注入，实际上fegin接口还未获取
	@Autowired
	SchedualServiceHi schedualServiceHi;
	@RequestMapping(value = "/hi") //直接封装参数 会报错
	public String sayHi(HttpServletRequest request) {
		return schedualServiceHi.sayHiFromClientOne(request.getParameter("name"));
	}

}
