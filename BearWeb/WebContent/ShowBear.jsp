<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "mjn.beardb.ejb.Bear" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Bear</title>
</head>
<body>
<% Bear b = (Bear)request.getAttribute("bear"); %>
<h2>Bear:</h2>
<form action="/BearWeb/MainServlet" method="post">
<p>
	<input type="text" name="txtName" value="<%=b.getName()%>">
</p>
	<input type="submit" name="submit" value="Back">
	<input name="operation" value="searchbear" type="hidden">
</form>
<br>
<h4>Add hat:</h4>
<form action="/BearWeb/MainServlet" method="post">
	<input type="text" name="hatColour">
	<input name="bearName" value="<%=b.getName() %>" type="hidden">
	<input name="operation" value="ajax-createHat" type="hidden">
	<input typr="submit" name="submit" value="Add">
</form>
</body>
</html>