package com.polaris.bootstrap;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.tyb.util.HttpRequest;

/**
 * @author 北辰不落雪 
 * @date 2017年12月2日 下午10:02:22 
 * @Description
 */
@RestController
public class WXRestful {
	String wxUrl = "https://api.weixin.qq.com";
	String access_token = "A0YWxvvpmWUB0qwSTFRarcNh9NA10oePTvmts6RWMFXwq1ROA3ARTZ2eI03_SAZdDIVtQw2qKf2aTxz70TqjnejpI71O70ZPaCmdmyKtjYTBtmRAcj-j94i9ZbzlrovQTMNcABADWX";
	String TEST_USER = "oTJqHv7f5UP_gIm25BXDN4XpZ8UE";
	String URL_SEND_MESSAGE = wxUrl+"/cgi-bin/message/custom/send?access_token="+access_token;
	String URL_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
	
	@RequestMapping("/wxxxx")
	public void weixin(HttpServletRequest request,HttpServletResponse response) {
		String TOKEN = "polarisnosnow";
		
		try {  
            // 开发者提交信息后，微信服务器将发送GET请求到填写的服务器地址URL上，GET请求携带参数  
            String signature = request.getParameter("signature");// 微信加密签名（token、timestamp、nonce。）  
            String timestamp = request.getParameter("timestamp");// 时间戳  
            String nonce = request.getParameter("nonce");// 随机数  
            String echostr = request.getParameter("echostr");// 随机字符串  
            PrintWriter out = response.getWriter();  
            // 将token、timestamp、nonce三个参数进行字典序排序  
            String[] params = new String[] { TOKEN, timestamp, nonce };  
            Arrays.sort(params);  
            // 将三个参数字符串拼接成一个字符串进行sha1加密  
            String clearText = params[0] + params[1] + params[2];  
            String algorithm = "SHA-1";  
            String sign = new String(
                    Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));  
            // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信  
            if (signature.equals(sign)) {  
                response.getWriter().print(echostr);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	@RequestMapping("/token")
	public String getAccessToken(HttpServletRequest request,HttpServletResponse response) {
		return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc19b762fc99ecc4d&secret=11a46cf67870ab7a7f7453288c78dc83";
	}
	
	@RequestMapping("/wx/send")
	public void send(@RequestParam String message){
		sendWX(URL_SEND_MESSAGE,TEST_USER,message);
	}
	
	/**
	 * @param url
	 * @param data
	 */
	private void sendWX(String url, String toUser,String message) {
		String data = "{\"touser\":\""+toUser+"\",\"msgtype\":\"text\",\"text\":{\"content\": \""+message+"\"}}";
		System.out.println(data);
		System.out.println(HttpRequest.sendPost(url, data));
	}
	
	/**
	 * @param url
	 * @param data
	 */
	private  static void sendTemplateWX(String url, String toUser,String message) {
		//String data = "{\"touser\":\""+toUser+"\",\"msgtype\":\"text\",\"text\":{\"content\": \""+message+"\"}}";
		/*Map<String, String> first = new HashMap<String, String>();
		first.put("value", message);
		first.put("color", "#FF0000");
		Map<String, String> faceAmt = new HashMap<String, String>();
		faceAmt.put("value", "200");
		faceAmt.put("color", "#C4C400");
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("first", first);
		data.put("faceAmt", faceAmt);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("touser", toUser);
		map.put("template_id", "j5Iz7nBgLdDmv8zT36SGtsYefKyGIoNDSq4qlORv9Eo");
		map.put("url", "http://weixin.qq.com/download");
		map.put("topcolor", "#FF0000");
		map.put("data", data);
		
		String jsonMap = JSONObject.toJSON(map).toString();
		System.out.println(jsonMap);*/
		String amt = "30";
		String phone = "15111032762";
		String openId = "oTJqHv7f5UP_gIm25BXDN4XpZ8UE";
		String templateId = "03XtLuTUcEl9ZFzs-PgvAMrkz26SvyjrfPmlRMTN4vU";
		String callUrl = "https://www.baidu.com";
		String appId = "wxe0eed0a3451e2a1e";
		
		Map<String, String> first = new HashMap<String,String>();
		first.put("value", "尊敬的嘉宾，你获得银盛购"+amt+"元优惠券一张");
		first.put("color", "#FF0000");
		
		Map<String, String> keyword1 = new HashMap<String,String>();
		keyword1.put("value", phone);
		keyword1.put("color", "#000000");
		
		Map<String, String> keyword2 = new HashMap<String,String>();
		keyword2.put("value", "2017年12月15日23时59分59秒");
		keyword2.put("color", "#000000");
		
		Map<String, String> remark = new HashMap<String,String>();
		remark.put("value", "点击查看贵宾礼遇，购物请使用微信扫描门店二维码。");
		remark.put("color", "#000000");
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("first", first);
		data.put("keyword1", keyword1);
		data.put("keyword2", keyword2);
		data.put("remark", remark);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("touser", openId);
		map.put("template_id", templateId);
		map.put("url", callUrl);
		map.put("topcolor", "#000000");
		map.put("data", data);
		System.out.println(HttpRequest.sendPost(url, JSONObject.toJSON(map).toString()));
	}
	public static void main(String[] args) {
		sendTemplateWX("http://weixin.ysepay.com/", null, null);
	}

	/**
	 * 模板消息发送
	 * @param request
	 * @returns
	 */
	@RequestMapping("/wx")
	public void templateMessage(HttpServletRequest request){
		try {
	        Map<String, String> restData = parseXml(request);
	        System.out.println(restData);
	        if("text".equals(restData.get("MsgType"))){
	        	sendTemplateWX(URL_TEMPLATE_MESSAGE,restData.get("FromUserName"),restData.get("Content"));
			}
	        if("event".equals(restData.get("MsgType"))){
	        	System.out.println("模板消息发送状态："+restData.get("Status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 客户消息发送
	 * @param request
	 * @return
	 */
	//@RequestMapping("/wx")
	public String allMessage(HttpServletRequest request){
		try {
	       /* String data = getRequestStringData(request);
	        System.out.println(data);
	        if (data.length() > 0) {
	            JSONObject jsonObject = JSONObject.parseObject(data);
	            sendWX(URL_SEND_MESSAGE,jsonObject.get("FromUserName")+"",jsonObject.get("Content")+"");
	        }*/
			
			/**
			 * xml方式
			 */
	        Map<String, String> restData = parseXml(request);
	        System.out.println(restData);
	        sendWX(URL_SEND_MESSAGE,restData.get("FromUserName"),restData.get("Content"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";//直接回复空串
	}

	public  Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
       // document.selectSingleNode("//")
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }
	
	//流读取
	private String getRequestStringData(HttpServletRequest request) {
	    StringBuffer info = new java.lang.StringBuffer();
	    InputStream in = null;
	    try {
	        in = request.getInputStream();
	        BufferedInputStream buf = new BufferedInputStream(in);
	        byte[] buffer = new byte[1024];
	        int iRead;
	        while ((iRead = buf.read(buffer)) != -1) {
	            info.append(new String(buffer, 0, iRead, "utf-8"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (null != in) {
	                in.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return info.toString();
	}
	
	private String getParams(HttpServletRequest req)
	{
		String state = req.getRequestURL()+"";
		Map map = req.getParameterMap();
		for (Object key : map.keySet()) {
			String v = req.getParameter(key.toString());
			if(state.indexOf('?') != -1)
			{
				state += "&"+key.toString()+"="+v;
			}else
			{
				state += "?"+key.toString()+"="+v;
			}
		}
		return state;
		
	}
	
}
