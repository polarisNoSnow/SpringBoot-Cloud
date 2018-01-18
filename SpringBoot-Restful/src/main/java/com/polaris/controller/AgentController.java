 package com.polaris.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.polaris.bean.Friend;

/**
 * @author 北辰不落雪 
 * @date 2017年12月25日 下午3:44:14 
 * @Description
 */
@RestController
public class AgentController {
	private Log log = LogFactory.getLog(AgentController.class);
	private static List<Friend> friends = new ArrayList<Friend>();
	static{
		/*一级菜单*/
		friends.add(new Friend("1","代理商管理", "index", "ok","0","1"));
		friends.add(new Friend("2","服务管理","friend", "ok", "0","0"));
		friends.add(new Friend("3","下载管理","", "ok","0","1"));
		
		/*二级菜单*/
		friends.add(new Friend("104","首页","index", "ok","1","0"));
		friends.add(new Friend("101","代收付查询","", "ok","1","1"));
		friends.add(new Friend("102","账单查询","", "ok","1","1"));
		friends.add(new Friend("301","月账单下载","", "ok","3","0"));
		/*三级菜单*/ 
		friends.add(new Friend("10101","代收查询","", "ok","101","0"));
		friends.add(new Friend("10104","月账单查询","friend", "ok","102","0"));
	}
	
	@RequestMapping(value="/permission",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String friends(HttpServletRequest request){
		String callback = request.getParameter("callback");
		Map<String, Object> data = new LinkedHashMap<String,Object>();
    	data.put("code", "10000");			
    	data.put("mesg", "ok");
    	data.put("data", friends);
    	log.info(JSON.toJSONString(data));
    	/*3.封装并返回信息*/
		//return "angular.callbacks._0(" + JSON.toJSONString(data) + ")";
    	return  callback+"("+JSON.toJSONString(data)+")";
	}
	
}
