package com.polaris.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.polaris.bean.Friend;

/**
 * @author 北辰不落雪 
 * @date 2017年12月25日 下午3:44:14 
 * @Description
 */
@RestController
public class FriendController {
	private Log log = LogFactory.getLog(FriendController.class);
	private static List<Friend> friends = new ArrayList<Friend>();
	static{
		friends.add(new Friend("1","polaris", "https://www.polaris.com", "ok","0",""));
		friends.add(new Friend("2","百度","https://www.baidu.com", "ok", "0",""));
		friends.add(new Friend("3","facebook","https://www.facebook.com", "ok","0",""));
	}
	
	@RequestMapping(value="/friends",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String friends(HttpServletRequest request){
		String callback = request.getParameter("callback");
		Map<String, Object> data = new HashMap<String,Object>();
    	data.put("code", "10000");			
    	data.put("mesg", "ok");
    	data.put("data", friends);
    	log.info(JSON.toJSONString(data));
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("code", "10000");			
    	jsonObject.put("mesg", "ok");
    	jsonObject.put("data", "test");
    	/*3.封装并返回信息*/
		//return "angular.callbacks._0(" + JSON.toJSONString(data) + ")";
    	return  callback+"("+JSON.toJSONString(data)+")";
	}
	
	@RequestMapping(value="/friend",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String friend(HttpServletRequest request){
		String callback = request.getParameter("callback");
		String id = request.getParameter("id");
		Friend friend = null;
		for (Friend f : friends) {
			if(f.getId().equals(id)){
				friend = f;
				break;
			}
		}
		Map<String, Object> data = new HashMap<String,Object>();
    	data.put("code", "10000");			
    	data.put("mesg", "ok");
    	data.put("data", friend);
    	log.info(JSON.toJSONString(data));
    	
    	/*3.封装并返回信息*/
		//return "angular.callbacks._0(" + JSON.toJSONString(data) + ")";
    	return  callback+"("+JSON.toJSONString(data)+")";
	}
}
