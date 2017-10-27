package com.hb.day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ex05 Get Method Page</h1>");
		out.println("<form method=\"post\">");		
		out.println("<p>id<input type=\"text\" name=\"id\" /></p>");		
		out.println("<p>pw<input type=\"text\" name=\"pw\" /></p>");		
		out.println("<p><button>Àü¼Û</button></p>");		
		out.println("</form>");		
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
	}
}











