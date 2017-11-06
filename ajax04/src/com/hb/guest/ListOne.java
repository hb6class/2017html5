package com.hb.guest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.utils.MyDb;

public class ListOne extends HttpServlet {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// /bbs/detail.html
	// <list>
	// <bean>
	// <sabun></>
	// <name></>...
	// </bean>
	// </list>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int sabun=Integer.parseInt(req.getParameter("idx"));
		resp.setContentType("text/xml; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<list>");
		try {
			conn=MyDb.getConnection();
			pstmt=conn.prepareStatement("select * from guest01 where sabun=?");
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next()){
				out.print("<bean>");
					out.print("<sabun>"+sabun+"</sabun>");
					out.print("<name>"+rs.getString("name")+"</name>");
					out.print("<nalja>"+rs.getDate("nalja")+"</nalja>");
					out.print("<pay>"+rs.getInt("pay")+"</pay>");
				out.print("</bean>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.print("</list>");
		
	}

}





