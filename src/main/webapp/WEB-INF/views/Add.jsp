<%@page import="com.jspider.springmvcproject.pojo. CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
    String msg = (String) request.getAttribute("msg"); %>
    <jsp:include page="NavBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<fieldset>
         <legend>add car details</legend>
          <form  action="./add" method="post" >
         <table>
         <tr>
         <td>Id</td>
          <td><input type="text" name="id"></td>
          </tr>
          <tr>
          <td>Name</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>Brand</td>
<td><input type="text" name="brand"></td>
</tr>
<tr>
<td>Fuiel Type</td>
<td><input type="text" name ="fuielType"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" name="price"></td>
</tr>
</table>
<input type="submit" value="ADD">
</form>
</fieldset>
</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (cars != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>BRAND</th>
				<th>FUIEL TYPE</th>
				<th>PRICE</th>
			</tr>
			<%
			for (CarPOJO pojo : cars) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
					<td><%=pojo.getBrand()%></td>
				<td><%=pojo.getFuielType()%></td>
				<td><%=pojo.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	
		

	
</body>
</html>