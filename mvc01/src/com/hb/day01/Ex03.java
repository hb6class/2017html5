package com.hb.day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet {
	
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
		out.println("<title>Insert title here</title>");
		out.println("<style type='text/css'>");
		out.println("	#menu>ul>li{float: left;list-style: none;}");
		out.println("	#content{clear: both;}");
		out.println("</style>");
		out.println("<script type='text/javascript'>");
		out.println("	window.onload=function(){");
		out.println("		var btn=document.querySelector('button');");
		out.println("		btn.onclick=function(){");
		out.println("			alert('msg');");
		out.println("		};};");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<div id='header'><img alt='logo' src='imgs/logo.jpg'></div>");
		out.println("	<div id='menu'>");
		out.println("		<ul><li>menu1</li><li>menu2</li><li>menu3</li><li>menu4</li></ul>");
		out.println("	</div>");
		out.println("	<div id='content'>");
		out.println("		<h1>제목</h1><p>내용</p>");
		out.println("		<button>btn</button>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
}









