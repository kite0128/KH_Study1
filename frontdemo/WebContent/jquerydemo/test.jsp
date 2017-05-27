<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String fname=request.getParameter("fname");//'id'가 아니라 'name'을 써야한다.
	out.print("이름 : "+fname);
%>
</body>
</html>