package com.polaris.start;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 北辰不落雪
 * @date 2017年11月16日 上午10:53:04
 * @Description
 */
@RestController
public class HelloControler {
	@Autowired
	HelloService helloService;

	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name) {
		return helloService.hiService(name);
	}
}
