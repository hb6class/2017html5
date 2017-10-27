package com.hb.day01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {

	
	private Connection conn;
	private PreparedStatement pstmt;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get 방식 한글처리
		// 톰캣 서버의 server.xml
		// URIEncoding="UTF-8" 속성 추가
		//     <Connector port="8080" URIEncoding="UTF-8" />
		String param1=req.getParameter("sabun");
		String param2=req.getParameter("name");
		String param3=req.getParameter("pay");
		int sabun=Integer.parseInt(param1);
		String name=param2;
		int pay=Integer.parseInt(param3);
		System.out.println("sabun:"+sabun);
		System.out.println("name:"+name);
		System.out.println("pay:"+pay);
		String sql="insert into guest01 values(?,?,sysdate,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe"
					,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			System.out.println("result:"+pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{			
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
}




















