package com.polaris.bean;

import java.io.Serializable;

/**
 * @author 北辰不落雪 
 * @date 2017年12月27日 上午11:38:09 
 * @Description 友链实体bean
 */
public class Friend implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6417665342172485535L;
	/**
	 * 
	 */
	
	private String id;
	private String name;
	private String url;
	private String state;
	private String pId;
	private String type; //节点类型,0叶子节点,1父节点
	
	public Friend() {
		super();
	}
	
	public Friend(String id, String name, String url, String state, String pId,String type) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.state = state;
		this.pId = pId;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
