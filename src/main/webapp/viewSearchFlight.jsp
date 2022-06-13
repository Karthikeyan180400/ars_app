<!DOCTYPE html>
<%@page import="com.ty.arsapp.service.impl.UserServiceImp"%>
<%@page import="com.ty.arsapp.dto.User"%>
<%@page import="com.ty.arsapp.dto.Flight"%>
<%@page import="java.util.List"%>
<html>
<head>
<style>
body {
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
	<%@include file="userNaviBar.jsp"%>
	<h2>Flight Details</h2>
	<% HttpSession httpSession = request.getSession();
   String email = (String)httpSession.getAttribute("email");
   String password = (String)httpSession.getAttribute("password");
   UserServiceImp userServiceImp = new UserServiceImp();
   User user = userServiceImp.validateUser(email, password);
%>

            <%
			List<Flight> flights = (List<Flight>) request.getAttribute("flightslist");
			%>
			<% if(flights.size()>0) { %>

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
			<th>Book Ticket</th>

			
			<%
			for (Flight flight : flights) {
			%>
		</tr>
		<tr>
			<td><%=flight.getId()%></td>
			<td><%=flight.getName()%></td>
			<td><%=flight.getBrand()%></td>
			<td><%=flight.getType()%></td>
			<td><%=flight.getDay()%></td>
			<td><%=flight.getDeparture()%></td>
			<td><%=flight.getDepartureDate()%></td>
			<td><%=flight.getDepartureTime()%></td>
			<td><%=flight.getDestination()%></td>
			<td><%=flight.getDestinationDate()%></td>
			<td><%=flight.getDestinationTime()%></td>
			<td><%=flight.getTicketCost()%></td>
			<td><%=flight.getNumberOfSeats()%></td>

			<td><a href="createBooking.jsp?fid=<%=flight.getId()%>&uid=<%=user.getId()%>">Book</a></td>

			<%
			}
			%>
			
	</table>
	<%} else { %>
			<h2>There is no flights available for that time</h2>
			<%} %>
			

</body>
</html>


