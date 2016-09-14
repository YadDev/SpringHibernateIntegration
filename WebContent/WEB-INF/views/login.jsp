

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<center>
	${msg}
		<c:url var="userRegistration" value="loginAuth" />
		<form:form id="loginform" modelAttribute="login" method="post"
			action="${userRegistration}">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="uName">Login Id</form:label></td>
					<td><form:input path="uName" /></td>
				</tr>
				<tr>
					<td><form:label path="pass">Password</form:label></td>
					<td><form:password path="pass" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form:form>
		<br> <a href="userRegistration">Click Here to Register Yourself</a>
	</center>
</body>
</html>