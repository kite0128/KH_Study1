<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>jsp_005_out</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name1 = request.getParameter("x");
	String name2 = request.getParameter("y");
	String ope = request.getParameter("ope");
	int n1 = Integer.parseInt(name1);
	int n2 = Integer.parseInt(name2);
	int result=0;
	
	switch(ope){
	case "+" :
		result=n1+n2;
		break;
	case "-" :
		result=n1-n2;
		break;
	case "*" :
		result=n1*n2;
		break;
	case "/" :
		result=n1/n2;
	}
	
	out.print("<p>"+result+"</p>");
	
%>
</body>
</html>