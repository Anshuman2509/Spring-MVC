<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
small{color:red};
#id{border:none;}
</style>
</head>
<body>
<form:form modelAttribute="jack" action="searchById">
<form:label path="empId">Employee Id</form:label>
<form:input path="empId" />
<form:errors path="empId"></form:errors>
<input type="submit" value="Search"/>
<button><a href='<c:url value="/emps"></c:url>'>Back</a></button>
</form:form>
<br>
<br>
<hr>
<table>
<tr><td>Employee Id</td><td>${fiat.empId }</td></tr>
<tr><td>Employee Name</td><td>${fiat.empName }</td></tr>
<tr><td>Date Of Joining</td><td>${fiat.dateOfJoining }</td></tr>
<tr><td>Gender</td><td>${fiat.gender }</td></tr>
<tr><td>City</td><td>${fiat.city }</td></tr>
<tr><td>Car</td><td>${fiat.car }</td></tr>
</table>
</body>
</html>