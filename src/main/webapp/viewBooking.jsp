<!DOCTYPE html>
<%@page import="com.ty.arsapp.dto.User"%>
<%@page import="com.ty.arsapp.dto.Booking"%>
<%@page import="com.ty.arsapp.dto.Flight"%>
<%@page import="java.util.List"%>
<html>
<head>
<style>
body{
    font-family: Arial, Helvetica, sans-serif;
}

#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 4px;
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
	text-align: center;
	background-color: navy;
	color: white;
}
</style>
</head>
<body>
<%@include file="userNaviBar.jsp" %>
	<h2>Booking Details</h2>

	<table id="customers">
		<tr>
			<th>Booking_ID</th>
			<th>Flight_ID</th>
			<th>User_ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>Departure</th>
			<th>DepartureDate</th>
			<th>DepartureTime</th>
			<th>Destination</th>
			<th>DestinationDate</th>
			<th>DestinationTime</th>
			<th>No.of.Seats</th>
			<th>TotalCost</th>
			<th>Booking_Status</th>
			

			<%
			Booking booking = (Booking)request.getAttribute("booking");
			Flight flight = booking.getFlight();
			User user = booking.getUser();
			%>

		</tr>
		<tr>
			<td><%= booking.getId()%></td>
			<td><%= flight.getId()%></td>
			<td><%= user.getId()%></td>
			<td><%= booking.getName() %></td>
			<td><%= booking.getEmail() %></td>
			<td><%= booking.getPhone() %></td>
			<td><%= booking.getGender() %></td>
			<td><%= booking.getDeparture() %></td>
			<td><%= booking.getDepartureDate() %></td>
			<td><%= booking.getDepartureTime() %></td>
			<td><%= booking.getDestination() %></td>
			<td><%= booking.getDestinationDate() %></td>
			<td><%= booking.getDestinationTime() %></td>
			<td><%= booking.getNumberOfSeats() %></td>
			<td><%= booking.getTotalCost() %></td>
			<td><%= booking.getBooking_status() %></td>
			
	</table>

</body>
</html>


