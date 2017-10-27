package com.hb.day01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneJson extends HttpServlet {
	// /detail.xml
	// {"":[{},{},{}]}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String sql="select sabun,name from guest01 where sabun=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, Integer.parseInt(req.getParameter("sabun")));
			rs = pstmt.executeQuery();
			
			resp.setContentType("application/json; charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("{\"guest01\":[");
			if(rs.next()){
			out.print("{\"sabun\":"+rs.getInt("sabun")
					+",\"name\":\""+rs.getString("name")+"\"}");
			}
			out.print("]}");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
	}
	
}





