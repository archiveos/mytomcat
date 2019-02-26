package com.cracker.httpserver.core;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * 负责封装响应参数对象
 * @author cracker
 * @version	1.0
 * @since	1.0
 *
 */
public class ResponseObject implements ServletResponse{
	private PrintWriter out;
	public void setWriter(PrintWriter out){
		this.out = out;
	}
	
	public PrintWriter getWriter(){
		return out;
	}
}
