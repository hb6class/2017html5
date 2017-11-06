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

public class UpdateOne extends HttpServlet{
	private Connection conn;
	private PreparedStatement pstmt;

	// /bbs/update.html
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String[] params=new String[3];
		params[0]=req.getParameter("sabun");
		params[1]=req.getParameter("name");
		params[2]=req.getParameter("pay");
		int sabun=Integer.parseInt(params[0]);
		String name=params[1];
		int pay=Integer.parseInt(params[2]);
		String sql="update guest01 set name=?,pay=? where sabun=?";
		try{
			pstmt=MyDb.getConnection().prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.setInt(3, sabun);
			pstmt.executeUpdate();
		}catch(Exception e){}finally{
				try {
					if(MyDb.getConnection()!=null) MyDb.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}









