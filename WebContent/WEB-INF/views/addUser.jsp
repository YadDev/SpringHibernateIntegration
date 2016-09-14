

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New User</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">New User Detail</div>
		<br>
		<br>
		<c:url var="userRegistration" value="saveUser" />
		<form:form id="registerForm" modelAttribute="user" method="post" 
			action="${userRegistration}">
			<table width="800px" height="150px">
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" /></td>
					 <td style="color: red; font-style: italic;"><form:errors path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" /></td>
					<td style="color: red; font-style: italic;"><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label></td>
					<td><form:radiobuttons path="gender" items="${model.gender}" /></td>
					  <td style="color: red; font-style: italic;"><form:errors path="gender" /></td>
				</tr>
				<tr>
					<td><form:label path="city">City</form:label></td>
					<td><form:select path="city" items="${model.city}"></form:select></td>
					 <td style="color: red; font-style: italic;"><form:errors path="city" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" /></td>
					 <td style="color: red; font-style: italic;"><form:errors path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">Mobile Number</form:label></td>
					<td><form:input path="phone" /></td>
					 <td style="color: red; font-style: italic;"><form:errors path="phone" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" />&nbsp &nbsp <a href="userList">Back</a></td>
				</tr>
			</table>
		</form:form>
		<br>

	</center>
</body>
</html>