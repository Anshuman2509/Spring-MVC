<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table{
width:80%;
margin:auto;
border:1px solid blue;
border-collapse:collapse;
}
td,th{
border:1px solid blue;
}
</style>
</head>
<body>
<div>
<h1>Automobiles Store</h1>
</div>
<table>
<tr><th>Automobile Id</th><th>Automobile</th><th>Parent</th><th>Country</th><th>Sales</th><th>Continent</th></tr>
<c:forEach items="${autos }" var="a">
<tr><td>${a.autoId }</td><td>${a.autoName }</td><td>${a.parent }</td><td>${a.country }</td><td>${a.sales }</td><td>${a.continent }</td></tr>
</c:forEach>
</table>
</body>
</html>