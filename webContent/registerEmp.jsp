<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<a href='<c:url value="/register?siteLanguage=en"></c:url>'>English</a><span> | </span>
<a href='<c:url value="/register?siteLanguage=fr"></c:url>'>French</a>
<div>
<h1><spring:message code="label.title"/></h1>
</div>
<div id="form">
<form:form modelAttribute="jio" action="save">
<table>
<tr>
<td><form:label path="empId"><spring:message code="label.empId"/></form:label></td>
<td><form:input path="empId"/></td>
<td><small><form:errors path="empId"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="empName"><spring:message code="label.empName"/></form:label></td>
<td><form:input path="empName"/></td>
<td><small><form:errors path="empName"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="dateOfJoining"><spring:message code="label.dateOfJoining"/></form:label></td>
<td><form:input type='text' path="dateOfJoining"/></td>
<td><small><form:errors path="dateOfJoining"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="gender"><spring:message code="label.gender"/></form:label></td>
<td><label>Male</label><form:radiobutton path="gender" value="M"/><label>Female</label><form:radiobutton path="gender" value="F"/></td>
<td><small><form:errors path="gender"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="city"><spring:message code="label.city"/></form:label></td>
<td><form:input path="city"/></td>
<td><small><form:errors path="city"></form:errors></small></td>
</tr>
<tr>
<td><form:label path="car"><spring:message code="label.car"/></form:label></td>
<td><form:input path="car"/></td>
<td><small><form:errors path="car"></form:errors></small></td>
</tr>
<tr><td><input type="submit" value="Submit"></td><td><button><a href='<c:url value="/emps"></c:url>'>Back</a></button></td></tr>
</table>
</form:form>
</div>
</body>
</html>