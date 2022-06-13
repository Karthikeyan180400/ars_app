<!DOCTYPE html>
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
<%@include file="adminNaviBar.jsp" %>
	<h2>Flight Details</h2>

	<table id="customers">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Brand</th>
			<th>Type</th>
			<th>Day</th>
			<th>Departure</th>
			<th>DepartureDate</th>
			<th>DepartureTime</th>
			<th>Destination</th>
			<th>DestinationDate</th>
			<th>DestinationTime</th>
			<th>TicketCost</th>
			<th>No.of.Seats</th>
			<th>Edit</th>
			<th>Delete</th>

			<%
			List<Flight> flights = (List<Flight>) request.getAttribute("flightsList");
			%>
			<%
			for (Flight flight : flights) {
			%>
		</tr>
		<tr>
			<td><%= flight.getId()%></td>
			<td><%= flight.getName() %></td>
			<td><%= flight.getBrand() %></td>
			<td><%= flight.getType() %></td>
			<td><%= flight.getDay() %></td>
			<td><%= flight.getDeparture() %></td>
			<td><%= flight.getDepartureDate() %></td>
			<td><%= flight.getDepartureTime() %></td>
			<td><%= flight.getDestination() %></td>
			<td><%= flight.getDestinationDate() %></td>
			<td><%= flight.getDestinationTime() %></td>
			<td><%= flight.getTicketCost() %></td>
			<td><%= flight.getNumberOfSeats() %></td>
			
			<td><a href="updateFlight.jsp?id=<%= flight.getId() %>">Edit</a></td>
			<td><a href="deleteFlight?id=<%= flight.getId() %>">Delete</a></td>
			
			<%
			}
			%>
		
	</table>

</body>
</html>


