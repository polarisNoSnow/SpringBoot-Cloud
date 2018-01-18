package com.polaris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polaris.bootstrap.SchedualServiceHi;

/**
 * @author 北辰不落雪 
 * @date 2017年11月16日 下午4:47:11 
 * @Description
 */
@Component
public class Remote {
	@Autowired
	public static SchedualServiceHi schedualServiceHi;
}
