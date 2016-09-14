<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
<script type="text/javascript">
function cnfDelete(){
	alert("Do You Want to Delete?");
}
</script>

</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">List of User Details</div>
		<div align="right">
			<a href="logout">Logout</a>
		</div>
		<br>
		<br>
		<c:if test="${!empty user}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					<td>User Id</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Gender</td>
					<td>City</td>
					<td>Email</td>
					<td>Mobile</td>
					<td colspan="2">Action</td>
				</tr>
				<c:forEach items="${user}" var="user">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						<td>${user.id}</td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.gender}" /></td>
						<td><c:out value="${user.city}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.phone}" /></td>
						<td><a href="edit/${user.id}">Edit</a></td>
						<td><a href="delete/${user.id}" onclick="cnfDelete()">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br> <a href="addUser">Click Here to add new User</a>
	</center>
</body>
</html>