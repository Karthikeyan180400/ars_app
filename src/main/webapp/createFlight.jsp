<!DOCTYPE html>
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
	<h2>Enter the Flight details</h2>

	<div class="container">
		<form action="createFlight">
			<table>
				<tr>
					<td><label for="name">Name</label> <input type="text"
						id="name" name="name" placeholder="Enter flight name.."></td>

					<td><label for="brand">Brand</label> <input type="text"
						id="brand" name="brand" placeholder="Enter flight brand..">
					</td>

					<td><label for="type">Type</label> <input type="text"
						id="type" name="type" placeholder=" Enter flight type..">
					</td>
				</tr>

				<tr>
					<td><label for="departure">Departure</label> <input
						type="text" id="departure" name="departure" placeholder=" From..">
					</td>

					<td><label for="departureDate">Departure Date</label> <input
						type="date" id="departureDatelname" name="departureDate">
					</td>

					<td><label for="departureTime">Departure Time</label> <input
						type="time" id="departureTime" name="departureTime"></td>
				</tr>

				<tr>

					<td><label for="destination">Destination</label> <input
						type="text" id="destination" name="destination"
						placeholder=" To.."></td>

					<td><label for="destinationDate">Destination Date</label> <input
						type="date" id="destinationDate" name="destinationDate">

					</td>

					<td><label for="destinationTime">Destination Time</label> <input
						type="time" id="destinationTime" name="destinationTime">
					</td>
				<tr>

					<td>Day<select name="day">
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
						placeholder="Enter flight ticket cost.."></td>

					<td>Number Of Seats<select name="numberOfSeats">
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
			<input type="submit" value="Submit">
		</form>
	</div>

</body>
</html>
