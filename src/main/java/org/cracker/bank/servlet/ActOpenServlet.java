package org.cracker.bank.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActOpenServlet implements Servlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) {
		//-----------从页面获取参数值------------
		String actno = request.getParameterValue("actno");
		double balance = Double.parseDouble(request.getParameterValue("balance"));
		
		//---------------连接数据库-------------
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cracker", "root", "root");
			//3.定义SQL语句框架
			String sql = "insert into t_act(actno,balance) values(?,?)";
			//4.进行SQL语句预编译
			ps = conn.prepareStatement(sql);
			//5.进行赋值
			ps.setString(1, actno);
			ps.setDouble(2, balance);
			//6.执行SQL语句
			count = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//获取响应流对象
		PrintWriter out = response.getWriter();
		if(count == 1){
			out.print("<html>");
			out.print("<head>");
			out.print("<title>银行帐户-开户结果</title>");
			out.print("<meta content='text/html;charset=utf-8'/>");
			out.print("</head>");
			out.print("<body>");
			out.print("<center><font size='35px' color='green'>恭喜您，开户成功！</font></center>");
			out.print("</body>");
			out.print("</html>");
		}else{
			out.print("<html>");
			out.print("<head>");
			out.print("<title>银行帐户-开户结果</title>");
			out.print("<meta content='text/html;charset=utf-8'/>");
			out.print("</head>");
			out.print("<body>");
			out.print("<center><font size='35px' color='red'>对不起，开户失败！</font></center>");
			out.print("</body>");
			out.print("</html>");
			
		}
	}

}
