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
margin-top:20px;
}
td,th{
border:1px solid blue;
}
</style>
</head>
<body>
<div>
<h1>Automobiles Store</h1>
<a href='<c:url value="register"></c:url>'>Add New Employee</a>&nbsp;&nbsp;
<a href='<c:url value="autos"></c:url>'>List Automobiles</a>&nbsp;&nbsp;
<a href='<c:url value="search"></c:url>'>Search Employee</a>&nbsp;&nbsp;
<a href='<c:url value="arithemetic"></c:url>'>Arithemetic Exception Sample</a>&nbsp;&nbsp;
<a href='<c:url value="array"></c:url>'>Array Out Of Bounds Exception Sample</a>
</div>
<table>
<tr><th>Employee Id</th><th>Employee Name</th><th>Date Of Joining</th><th>Car</th><th>Update</th><th>Delete</th></tr>
<c:forEach items="${e }" var="a">
<tr><td>${a.empId }</td><td>${a.empName }</td><td>${a.dateOfJoining }</td><td>${a.car }</td>
<td><a href='<c:url value="/update?empId=${a.empId }"></c:url>'>Update</a></td><td><a href='<c:url value="/delete?id=${a.empId }"></c:url>'>Delete</a></td></tr>
</c:forEach>
</table>
</body>
</html>