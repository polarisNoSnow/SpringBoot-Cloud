package com.polaris.bootstrap;

import org.springframework.stereotype.Component;

/**
 * @author 北辰不落雪 
 * @date 2017年11月16日 下午6:54:52 
 * @Description
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

	/* 
	 * @see com.polaris.bootstrap.SchedualServiceHi#sayHiFromClientOne(java.lang.String)
	 */
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry "+name;
	}

}
