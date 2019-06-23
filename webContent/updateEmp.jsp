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
</style>
</head>
<body>
<div>
<h1>Automobiles Store</h1>
</div>
<div id="form">
<form:form modelAttribute="jio" action="updateEmp">
<table>
<tr>
<td><form:label path="empId">Employee Id</form:label></td>
<td><form:input style="border:none" path="empId" readonly="true"/></td>
<td><small><form:errors path="empId"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="empName">Employee Name</form:label></td>
<td><form:input path="empName"/></td>
<td><small><form:errors path="empName"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="dateOfJoining">Date of Joining</form:label></td>
<td><form:input type='text' path="dateOfJoining"/></td>
<td><small><form:errors path="dateOfJoining"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="gender">Gender</form:label></td>
<td><label>Male</label><form:radiobutton path="gender" value="M"/><label>Female</label><form:radiobutton path="gender" value="F"/></td>
<td><small><form:errors value="gender"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="city">City</form:label></td>
<td><form:input path="city"/></td>
<td><small><form:errors path="city"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="car">Car</form:label></td>
<td><form:input path="car"/></td>
<td><small><form:errors path="car"></form:errors></small></td>
</tr>
<tr><td><input type="submit" value="Submit"></td><td><button><a href='<c:url value="/emps"></c:url>'>Back</a></button></td></tr>
</table>
</form:form>

</div>
</body>
</html>