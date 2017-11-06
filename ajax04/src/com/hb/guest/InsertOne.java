package com.hb.guest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.utils.MyDb;

public class InsertOne extends HttpServlet {

	private Connection conn;
	private PreparedStatement pstmt;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String param1=req.getParameter("sabun");
		String param2=req.getParameter("name");
		String param3=req.getParameter("pay");
		int sabun=Integer.parseInt(param1);
		String name=param2;
		int pay=Integer.parseInt(param3);
		
		String sql="insert into guest01 values(?,?,sysdate,?)";
		
		try {
			conn= MyDb.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}


















