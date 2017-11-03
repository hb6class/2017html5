package com.hb.day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet {
	//	/target/list.json
	// {"key":[{},{}]}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("{\"list\":[");
		out.print("{\"sabun\":1111,\"name\":\"guest01\"}");
		out.print(",");
		out.print("{\"sabun\":2222,\"name\":\"guest02\"}");
		out.print(",");
		out.print("{\"sabun\":3333,\"name\":\"guest03\"}");
		out.print(",");
		out.print("{\"sabun\":4444,\"name\":\"guest04\"}");
		out.print(",");
		out.print("{\"sabun\":5555,\"name\":\"guest05\"}");
		out.print("]}");
	}
}













