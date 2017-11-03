package com.hb.day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02 extends HttpServlet {
	// /target/list.xml
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/xml; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<lists>");
			out.print("<list>");
				out.print("<sabun>"+1111+"</sabun>");
				out.print("<name>"+"guest01"+"</name>");
			out.print("</list>");		
			out.print("<list>");
			out.print("<sabun>"+2222+"</sabun>");
			out.print("<name>"+"guest02"+"</name>");
			out.print("</list>");		
			out.print("<list>");
			out.print("<sabun>"+3333+"</sabun>");
			out.print("<name>"+"guest03"+"</name>");
			out.print("</list>");		
		out.print("</lists>");
		
	}
}











