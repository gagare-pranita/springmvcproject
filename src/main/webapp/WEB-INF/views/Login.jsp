<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%String msg=(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<div align="center" >
<%
if(msg!=null){
%>
<h3><%=msg %></h3>
<%} %>
<fieldset>
<legend>LOGIN PAGE</legend>

<form action="./login" method="post">
<table>
<tr>
<td>USERNAME</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="passwrd"></td>
</tr>
</table>
<input type="submit" value="LOGIN">
</form>
</fieldset>
<a href="http://localhost:8080/springmvcproject/createAccount"> Create Account</a>
</div>
</body>
</html>