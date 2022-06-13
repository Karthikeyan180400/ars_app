<!DOCTYPE html>
<%@page import="com.ty.arsapp.dto.Employee"%>
<html>
<head>
<style>
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
<%@include file="naviBar.jsp" %>
	<h2>Profile Details</h2>

	<table id="customers">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Edit</th>
			<th>Delete</th>

			<%
			  Employee employee = (Employee)request.getAttribute("employee");
			%>
		
		</tr>
		<tr>
			<td><%= employee.getId()%></td>
			<td><%= employee.getName() %></td>
			<td><%= employee.getRole() %></td>
			<td><%= employee.getGender() %></td>
			<td><%= employee.getEmail() %></td>
			<td><%= employee.getPassword() %></td>
			<td><%= employee.getPhone() %></td>
			<td><a href="edit?id=<%= employee.getId() %>">Edit</a></td>
			<td><a href="delete?id=<%= employee.getId() %>">Delete</a></td>
			
			
		
	</table>

</body>
</html>


