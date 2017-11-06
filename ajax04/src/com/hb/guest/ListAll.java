package com.hb.guest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import com.hb.utils.MyDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListAll extends HttpServlet {
	// /bbs/list.xml
	// <list>
	// 		<bean>
	//			<sabun>
	//			<name/>
	// ...</bean>
	// </list>

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		resp.setContentType("application/xml; charset=UTF-8");
		resp.setContentType("text/xml; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<list>");
		try{
			Connection conn=MyDb.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from guest01");
			ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				out.print("<bean>");
					out.print("<sabun>");
					out.print(rs.getInt("sabun"));
					out.print("</sabun>");
					out.print("<name>");
					out.print(rs.getString("name"));
					out.print("</name>");
					out.print("<nalja>");
					out.print(rs.getDate("nalja"));
					out.print("</nalja>");
					out.print("<pay>");
					out.print(rs.getInt("pay"));
					out.print("</pay>");
				out.print("</bean>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		out.print("</list>");
	}
}











