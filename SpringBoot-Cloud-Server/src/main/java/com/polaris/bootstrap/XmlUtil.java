/*package com.polaris.bootstrap;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

*//**
 * @author 北辰不落雪
 * @date 2017年12月3日 上午1:57:02
 * @Description
 *//*
public class XmlUtil {
	*//**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request
	 * @return Map<String, String>
	 * @throws Exception
	 *//*
	// @SuppressWarnings("unchecked")
	public static HashMap<String, String> parseXML(HttpServletRequest request)
			throws Exception {
		// 将解析结果存储在HashMap中
		HashMap<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(request.getInputStream());
		// 得到xml根元素
		Element root = document.getRootElement();

		recursiveParseXML(root, map);

		inputStream.close();
		inputStream = null;

		return map;
	}

	private static void recursiveParseXML(Element root,
			HashMap<String, String> map) {
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();
		// 判断有没有子元素列表
		if (elementList.size() == 0) {
			map.put(root.getName(), root.getText());
		} else {
			// 遍历
			for (Element e : elementList) {
				recursiveParseXML(e, map);
			}
		}
	}
	
	*//**
     * 扩展xstream使其支持CDATA
     *//*
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                //@SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
*//**
     * 文本消息对象转换成xml
     * 
     * @param textMessage 文本消息对象
     * @return xml
     *//*
    public static String messageToXML(TextMessage textMessage) {
        xstream.alias("xml", TextMessage.class);
        return xstream.toXML(textMessage);
    }

    *//**
     * 图片消息对象转换成xml
     * 
     * @param imageMessage 图片消息对象
     * @return xml
     *//*
    public static String messageToXML(ImageMessage imageMessage) {
        xstream.alias("xml", ImageMessage.class);
        return xstream.toXML(imageMessage);
    }
*//**
     * 语音消息对象转换成xml
     * 
     * @param voiceMessage 语音消息对象
     * @return xml
     *//*
    public static String messageToXML(VoiceMessage voiceMessage) {
        xstream.alias("xml", VoiceMessage.class);
        return xstream.toXML(voiceMessage);
    }

    *//**
     * 视频消息对象转换成xml
     * 
     * @param videoMessage 视频消息对象
     * @return xml
     *//*
    public static String messageToXML(VideoMessage videoMessage) {
        xstream.alias("xml", VideoMessage.class);
        return xstream.toXML(videoMessage);
    }

}
*/