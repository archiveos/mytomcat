package com.cracker.httpserver.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析server.xml配置文件
 * @author cracker
 * @version	1.0
 * @since	1.0
 *
 */
public class ServerParser {
	
	/**
	 * 获取服务器的端口号
	 * @return int port
	 */
	public static int getPort(){
		//设置服务器默认端口号：8080
		int port = 8080;
		try {
			//创建解析器
			SAXReader saxReader = new SAXReader();
			//通过解析器的read方法将配置文件读取到内存中，生成一个Document[org.dom4j]对象树
			Document document = saxReader.read("conf/server.xml");
			//获取connector节点元素的路径：server -> service -> connector
			//获取connector节点元素的xpath路径：/server/service/connector
			//获取connector节点元素的xpath路径：server//connector
			//获取connector节点元素的xpath路径：//connector
			Element connectorElt = (Element) document.selectSingleNode("//connector");
			//获取port属性的值
			port = Integer.parseInt(connectorElt.attributeValue("port"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return port;
	}
}
