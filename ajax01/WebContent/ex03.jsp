<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
<%
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	if("admin".equals(id)&&"1234".equals(pw)){
		out.print("<p>관리자님 환영합니다</p>");
	}else{
		out.print("<p>"+id+"님 환영합니다</p>");		
	}

%>
</body>
</html>












