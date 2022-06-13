<!DOCTYPE html>
<%@page import="com.ty.arsapp.dto.Flight"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.arsapp.service.impl.FlightServiceImp"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

button {
	background-color: navy;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	background-color: #111;
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
</head>
<body>
	<%@include file="adminNaviBar.jsp"%>

	<h2>View Flights</h2>

	<%
	FlightServiceImp flightServiceImp = new FlightServiceImp();
	List<Flight> flights = flightServiceImp.getAllFlights();
	%>
	<div class="container">
		<table>

			<tr>
				<td>
					<form action="getAllFlightsByType" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Type</th>
								<td><select name="type">
										<option value="">------</option>
										<option value="AC">AC</option>
										<option value="Non-AC">Non-AC</option>

								</select></td>
								<td><button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button></td>
							</tr>
						</table>

					</form>
				</td>
			</tr>

			<tr>
				<td>
					<form action="getAllFlightsByDay" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Day</th>
								<td><select name="day">
										<option value="">------</option>
										<option value="Monday">Monday</option>
										<option value="Tuesday">Tuesday</option>
										<option value="Wednesday">Wednesday</option>
										<option value="Thursday">Thursday</option>
										<option value="Friday">Friday</option>
										<option value="Saturday">Saturday</option>
										<option value="Sunday">Sunday</option>
								</select></td>
								<td><button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button></td>

							</tr>
						</table>

					</form>
				</td>
			</tr>

			<tr>
				<td>
					<form action="getAllFlightsByName" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Name</th>
								<td><select name="name">
										<option value="">------</option>

										<%
										for (Flight flight : flights) {
										%>
										<option value="<%=flight.getName()%>"><%=flight.getName()%></option>
										<%
										}
										%>
								</select></td>
								<td><button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button></td>
							</tr>
						</table>

					</form>
				</td>
			</tr>

			<tr>
				<td>
					<form action="getAllFlightsByCost" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Ticket Cost</th>
								<td><select name="cost">
										<option value="">------</option>
										<%
										for (Flight flight : flights) {
										%>
										<option value="<%=flight.getTicketCost()%>"><%=flight.getTicketCost()%></option>
										<%
										}
										%>
								</select></td>
								<td><button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button></td>
							</tr>
						</table>

					</form>
				</td>
			</tr>

			<tr>
				<td>
					<form action="getAllFlightsByDeparture" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Departure</th>
								<td><select name="departure">
										<option value="">------</option>
										<option value="Bangalore">Bangalore</option>
										<option value="Chennai">Chennai</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Trichy">Trichy</option>
								</select></td>
								<td><button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button></td>

							</tr>
						</table>

					</form>
				</td>
			</tr>

			<tr>
				<td>
					<form action="getAllFlightsByDestination" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Destination</th>
								<td><select name="destination">
										<option value="">------</option>
										<option value="Bangalore">Bangalore</option>
										<option value="Chennai">Chennai</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Trichy">Trichy</option>
								</select></td>
								<td><button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button></td>

							</tr>
						</table>

					</form>
				</td>
			</tr>

			<tr>
				<td>
					<form action="getAllFlightsByDestinationDate" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Destination Date</th>
								<td><input type="date" id="destinationDate"
									name="destinationDate"></td>
								<td>
									<button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button>
								</td>
							</tr>
						</table>

					</form>
				</td>
			</tr>

			<tr>
				<td>
					<form action="getAllFlightsByDepartureDate" method="post">
						<table cellspacing="20px">
							<tr>
								<th>By Departure Date</th>
								<td><input type="date" id="departureDate"
									name="departureDate"></td>
								<td>
									<button type="submit">&nbsp;&nbsp;Find&nbsp;&nbsp;</button>
								</td>
							</tr>
						</table>

					</form>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>
