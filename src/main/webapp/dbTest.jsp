<%@page import="alcohol.mvc.util.DbUtil"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>db연결</h1>

<%
	Connection con =DbUtil.getConnection();
	out.println("con = "+con);
%>

</body>
</html>