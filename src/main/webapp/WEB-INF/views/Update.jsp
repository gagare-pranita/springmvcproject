
<%@page import="com.jspider.springmvcproject.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
     <%  List<CarPOJO> cars=(List<CarPOJO>) request.getAttribute("cars");
   CarPOJO pojo=(CarPOJO) request.getAttribute("car");
   String msg=(String) request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<%if(pojo==null)
	{ %>
	<fieldset>
	<legend>select Car </legend>

	<form action="./update" method="post">
	<table>
	<tr>
	<td>Enter Id</td>
	<td><input type="text" name="id"></td>
	</tr>
	</table>
	<input type="submit" value="SELECT">
	</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
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
			for (CarPOJO car :cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getFuielType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
	} else{
		%>
	<fieldset>
	<legend>update car</legend>
	<form action="./updateCar" method="post">
	<table>
	<tr>
	<td>ID</td>
	<td><%=pojo.getId()%></td>
	<td><input type="text" name="id" value="<%=pojo.getId() %>" hidden="true"></td>
	</tr>
	<tr>
	<td>NAME</td>
	<td><input type="text" name="name" value="<%=pojo.getName() %>"></td>
	</tr>
	<tr>
	<td>BRAND</td>
	<td><input type="text" name="email" value="<%=pojo.getBrand() %>"></td>
	</tr>
	<tr>
	<td>FUIEL TYPE</td>
	<td><input type="text" name="contact" value="<%=pojo.getFuielType()%>"></td>
	</tr>
	<tr>
	<td>PRICE</td>
	<td><input type="text" name="address" value="<%=pojo.getPrice()%>"></td>
	</tr>
	</table>
	<input type="submit" value="UPDATE">
	</form>

	</fieldset>
	<%} %>
	</div>

</body>
</html>