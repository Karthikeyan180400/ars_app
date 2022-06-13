<!DOCTYPE html>
<%@page import="com.ty.arsapp.dto.Flight"%>
<%@page import="com.ty.arsapp.service.impl.FlightServiceImp"%>
<html>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=email], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=number], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=date], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-family: Arial;
}

input[type=time], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-family: Arial;
}

input[type=submit] {
	width: 100%;
	background-color: navy;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	align-self: center;
}

select-selected:after {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit]:hover {
	background-color: #11;
}

div.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>
	<%@include file="adminNaviBar.jsp"%>
	<h2>Update the Flight details</h2>

    <% FlightServiceImp flightServiceImp = new FlightServiceImp();
       Flight flight = flightServiceImp.getFlightById(Integer.parseInt(request.getParameter("id")));
    %>
	<div class="container">
		<form action="updateFlight">
			<table>
			    <tr>
			    <td><label for="id">ID</label> <input type="number"
						id="id" name="id" value="<%= flight.getId() %>" readonly="readonly"></td>
			    </tr>
				<tr>
					<td><label for="name">Name</label> <input type="text"
						id="name" name="name" value="<%= flight.getName() %>"></td>

					<td><label for="brand">Brand</label> <input type="text"
						id="brand" name="brand" value="<%= flight.getBrand() %>">
					</td>

					<td><label for="type">Type</label> <input type="text"
						id="type" name="type" value="<%= flight.getType() %>">
					</td>
				</tr>

				<tr>
					<td><label for="departure">Departure</label> <input
						type="text" id="departure" name="departure" value="<%= flight.getDeparture() %>">
					</td>

					<td><label for="departureDate">Departure Date</label> <input
						type="date" id="departureDatelname" name="departureDate" value="<%= flight.getDepartureDate() %>">
					</td>

					<td><label for="departureTime">Departure Time</label> <input
						type="time" id="departureTime" name="departureTime" value="<%= flight.getDepartureTime() %>"></td>
				</tr>

				<tr>

					<td><label for="destination">Destination</label> <input
						type="text" id="destination" name="destination"
						value="<%= flight.getDestination() %>"></td>

					<td><label for="destinationDate">Destination Date</label> <input
						type="date" id="destinationDate" name="destinationDate" value="<%= flight.getDestinationDate() %>">

					</td>

					<td><label for="destinationTime">Destination Time</label> <input
						type="time" id="destinationTime" name="destinationTime" value="<%= flight.getDestinationTime() %>">
					</td>
				<tr>

					<td>Day<select name="day">
					        <option value="<%= flight.getDay() %>"><%= flight.getDay() %></option>
							<option value="Monday">Monday</option>
							<option value="Tuesday">Tuesday</option>
							<option value="Wednesday">Wednesday</option>
							<option value="Thursday">Thursday</option>
							<option value="Friday">Friday</option>
							<option value="Saturday">Saturday</option>
							<option value="Sunday">Sunday</option>
					</select>
					<td><label for="ticketCost">Ticket Cost</label> <input
						type="number" id="ticketCost" name="ticketCost"
						value="<%= flight.getTicketCost() %>"></td>

					<td>Number Of Seats<select name="numberOfSeats">
					        <option value="<%= flight.getNumberOfSeats() %>"><%= flight.getNumberOfSeats() %></option>
							<option value="30">30</option>
							<option value="31">31</option>
							<option value="32">32</option>
							<option value="33">33</option>
							<option value="34">34</option>
							<option value="35">35</option>
							<option value="36">36</option>
							<option value="37">37</option>
							<option value="38">38</option>
							<option value="39">39</option>
							<option value="40">40</option>
					</select>
					</td>

				</tr>

			</table>
			<input type="submit" value="Update">
		</form>
	</div>

</body>
</html>
