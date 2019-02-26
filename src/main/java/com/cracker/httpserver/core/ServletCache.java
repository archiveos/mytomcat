package com.cracker.httpserver.core;

import javax.servlet.Servlet;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet对象缓存池
 * @author cracker
 * @version	1.0
 * @since	1.0
 *
 */
public class ServletCache {
	private static Map<String,Servlet> servletMap = new HashMap<String, Servlet>();
	
	public static void put(String urlPattern,Servlet servlet){
		servletMap.put(urlPattern, servlet);
	}
	
	public static Servlet get(String urlPattern){
		return servletMap.get(urlPattern);
	}
}
