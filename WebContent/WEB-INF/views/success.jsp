<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User </title>

</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">
			Edit User</div>
<c:url var="updateUser" value="updateUser" />
		<form:form id="registerForm" modelAttribute="user" method="post"
			action="updateUser">
		
			
			<table width="400px" height="150px">
				<tr>
					
					<td><form:hidden path="id" /></td>
				</tr>
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label></td>
					<td><form:input path="gender"/></td>
				</tr>
				<tr>
					<td><form:label path="city">City</form:label></td>
					<td><form:input path="city"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update" />
					</td>
				</tr>
			</table>
		</form:form>


		
	</center>
</body>
</html>