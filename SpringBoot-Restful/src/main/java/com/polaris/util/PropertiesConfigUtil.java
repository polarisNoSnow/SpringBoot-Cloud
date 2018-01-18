package com.polaris.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesConfigUtil {
	private static Properties config;
	
	/**
	 * 固定加载config文件夹下的指定文件
	 * @param file
	 * @throws IOException
	 */
	public PropertiesConfigUtil(String file) throws IOException{
		config = new Properties();
		if(file != null){
			String filePath = System.getProperty("user.dir") + File.separator
					+ "config" + File.separator + file;
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			config.load(in);
		}else{
			throw new IOException(); 
		}
	}
	
	/**
	 * 全路径文件加载
	 * @param filePaths
	 * @throws IOException
	 */
	public PropertiesConfigUtil(List<String> filePaths) throws IOException{
		if(filePaths != null){
			config = new Properties();
			InputStream in = null;
			for (int i = 0; i < filePaths.size(); i++) {
				if(StringUtils.isBlank(filePaths.get(i))){
					continue;
				}
				in = new BufferedInputStream(new FileInputStream(filePaths.get(i)));
				config.load(new InputStreamReader(in, "GBK"));//window的ANSI编码默认为GBK
			}
			
		}else{
			throw new IOException(); 
		}
	}
	
	/**
	 * 获取信息
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return config.getProperty(key);
	}
	
}
