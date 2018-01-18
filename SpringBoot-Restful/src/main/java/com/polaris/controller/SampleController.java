package com.polaris.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.polaris.util.PropertiesConfigUtil;

/**
 * 
 * @author 北辰不落雪
 *
 */
@RestController
public class SampleController {
	private Log log = LogFactory.getLog(SampleController.class);
	
	@Value("${filePath}")
	private String filePath;
	
	/**
	 * 
	 * @param varidatecode 订单唯一标识
	 * @param pos_no POS机终端号
	 * @param checkValue 签名
	 * @param mercId 终端商户号
	 * @param data59 59域扩展域
	 * @return
	 */
    @RequestMapping(value="/message",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String serverHello(HttpServletRequest request) { 
    	load();
    	String message = PropertiesConfigUtil.getProperty("message");
    	/*1.加载平台文件，获取平台信息*/
    	System.out.println("message:"+message);
    	Map<String, String> data = new HashMap<String,String>();
    	data.put("code", "10000");			
    	data.put("mesg", "ok");
    	data.put("data", message);
    	log.info(JSON.toJSONString(data));
    	/*3.封装并返回信息*/
		return JSON.toJSONString(data);
    }
    
    /*全路径多文件加载*/
    private void load() {
    	List<String> file = new ArrayList<String>();
		file.add(filePath);
		try {
			new PropertiesConfigUtil(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	/*try{
    		PropertiesConfigUtil.getProperty("");
    	}catch(NullPointerException e){
    		List<String> file = new ArrayList<String>();
    		file.add(filePath);
    		try {
				new PropertiesConfigUtil(file);
				System.err.println(filePath+"加载成功");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}*/
	}

	@RequestMapping("/bye")
    public String serverBye() {
    	System.out.println(filePath+"4456");
        return "bye:服务二..sasas";
    }
    
    @RequestMapping(value="/getAngular",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
    public String getAngular(HttpServletRequest request){
    	System.out.println(request.getParameter("name"));
    	Map<String, String> data = new HashMap<String, String>();
    	data.put("username", "hello,"+request.getParameter("name"));
    	data.put("birthday", "19940127");
    	return data.toString();
    }
	protected Map<String, String> parseRequest(HttpServletRequest request) {
		Map map = null;
		try {
			StringBuffer sb = new StringBuffer();
			InputStream stream = request.getInputStream();
			if(stream == null) {
				System.out.println("收到空报文，结束");
				return null;
			}
			BufferedInputStream br = new BufferedInputStream(stream);
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len = br.read(buffer)) != -1){
				sb.append(new String(buffer,0,len,"UTF-8"));
			}
//			System.out.println("收到报文："+sb);
			
			map = (Map) JSONObject.parse(sb.toString());
			
			System.out.println("收到报文："+JSONObject.toJSONString(map));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
