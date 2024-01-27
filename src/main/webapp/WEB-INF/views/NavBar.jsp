<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">


fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #666;
}

ul {
	list-style-type: none;
	background-color: aqua;
	overflow: hidden;
	background-color: #666;
}

li {
	float: right;
}

li a {
	display: block;
	margin: 0px;
	padding: 15px;
}

li a:hover {
	background-color: pink;
}
</style>
</head>
<body>
	<ul>
		<li><a style="color: white;" href="./logout">Logout</a></li>
		<li><a style="color: white;" href="./search">Search car details</a></li>
		<li><a style="color: white;" href="./add">Add car details</a></li>
		<li><a style="color: white;" href="./update">Update car details</a></li>
		<li><a style="color: white;" href="./remove">Remove  car details</a></li>
		<li><a style="color: white;" href="./home">Home</a></li>
	</ul>
</body>
</html>