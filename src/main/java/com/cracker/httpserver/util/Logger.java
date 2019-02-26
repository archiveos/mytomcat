package com.cracker.httpserver.util;

/**
 * 日志记录器
 * @author cracker
 * @version	1.0
 * @since	1.0
 *
 */
public class Logger {
	//工具类的方法往往是静态的，直接通过类名调用，不需要去创建对象
	//工具类的构造方法往往也是私有，但不是必须的
	private Logger(){
	}
	
	/**
	 * 普通日志记录器
	 * @param msg
	 */
	public static void log(String msg){
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date nowTime = new Date();
		String nowTimeStr = dateFormat.format(nowTime);*/
		System.out.println("[INFO] " + DateUtil.getCurrentTime() + " " + msg);
	}
}	
