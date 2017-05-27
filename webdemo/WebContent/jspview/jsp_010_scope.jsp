<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>jsp_010_scope</title>
</head>
<body>
<%
/*
scope(영역)-데이터를 참조할 수 있도록 저장해놓은 공간
*/

//page영역에 p1이름으로 page값이 저장된다.
pageContext.setAttribute("p1", "page");
//request영역에 p2이름으로 request값이 저장된다.
request.setAttribute("p2", "request");
//session영역에 p3이름으로 session값이 저장된다.
session.setAttribute("p3", "session");
//application영역에 p4이름으로 application값이 저장된다.
application.setAttribute("p4", "application");

%>

<jsp:forward page="jsp_010_next.jsp"/>

</body>
</html>