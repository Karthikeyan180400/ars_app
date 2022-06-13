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
		    <th>User_ID</th>
			<th>Booking_ID</th>
			<th>Flight_ID</th>
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
			<th>Update Booking</th>
			<th>Cancel Booking</th>
			

			<%
			User user = (User)request.getAttribute("user");
			List<Booking> bookings = (List<Booking>)request.getAttribute("bookings");
			%>

		</tr>
		  <%for(Booking booking:bookings){ %>
		<tr>
		    <td><%= user.getId()%></td>
			<td><%= booking.getId()%></td>
			<td><%= booking.getFlight().getId()%></td>
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
			
			<td><a href="updateBooking.jsp?id=<%= booking.getId() %>&fid=<%= booking.getFlight().getId() %>&uid=<%= booking.getUser().getId() %>">Update</a></td>
			<td><a href="cancelBooking?id=<%= booking.getId() %>">Cancel</a></td>
			
			<%} %>
		</tr>
	</table>

</body>
</html>


