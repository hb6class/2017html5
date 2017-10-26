<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	boolean result=false;
	if("admin".equals(id)&&"1234".equals(pw)){
		result=true;
	}
%>
<root>
	<login>
		<result><%=result %></result>
		<username><%=id %></username>
	</login>
</root>