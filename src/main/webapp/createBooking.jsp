<!DOCTYPE html>
<%@page import="com.ty.arsapp.service.impl.FlightServiceImp"%>
<%@page import="com.ty.arsapp.dto.Flight"%>
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

select-selected:after{
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
<%@include file="userNaviBar.jsp" %>
<h2>Enter the Flight details</h2>

<div class="container">
  <form action="createBooking">
  <table>
  <tr>
    <td >
    <label for="name">Flight ID</label>
    <input type="text" id="name" name="fid"  value="<%=request.getParameter("fid") %>">
    </td>
    
    <td >
    <label for="name">User ID</label>
    <input type="text" id="name" name="uid"  value="<%=request.getParameter("uid") %>">
    </td>
    
    <td >
    <label for="name">Name</label>
    <input type="text" id="name" name="name" placeholder="Enter your name..">
    </td>
    
   </tr>
   
   <tr>
   <td><p>Gender</p></td>
   
   <td>
    <label class="container">
    <input type="radio"  name="gender" value="male">Male
    <span class="checkmark"></span>
    </label>
    
    <label class="container">
    <input type="radio" name="gender"  value="female">Female
    <span class="checkmark"></span>
    </label>
   </td>
   </tr>
  <tr>
    
    <td >
    <label for="brand">Email</label>
    <input type="text" id="brand" name="email" placeholder="Enter your email..">
    </td>
    
    <td >
    <label for="type">Phone</label>
    <input type="text" id="type" name="phone" placeholder=" Enter the phone num..">
    </td>
    
    <td >
    <label for="seats">Number Of Seats</label>
    <input type="number" id="seats" name="seats" placeholder="Enter seats count..">
    </td>
  </tr>
   <% FlightServiceImp flightServiceImp = new FlightServiceImp();
      Flight flight = flightServiceImp.getFlightById(Integer.parseInt(request.getParameter("fid")));
   %>
  <tr>
    <td >
    <label for="departure">Departure</label>
    <input type="text" id="departure" name="departure" value="<%= flight.getDeparture() %>" readonly="readonly">
    </td>
    
    <td >
    <label for="departureDate">Departure Date</label>
    <input type="date" id="departureDatelname" name="departureDate" value="<%= flight.getDepartureDate() %>" readonly="readonly">
    </td>
    
    <td >
    <label for="departureTime">Departure Time</label>
    <input type="time" id="departureTime" name="departureTime" value="<%= flight.getDepartureTime() %>" readonly="readonly">
    </td>
  </tr> 
  
  <tr>
    
    <td >
    <label for="destination">Destination</label>
    <input type="text" id="destination" name="destination" value="<%= flight.getDestination() %>" readonly="readonly">
    </td>
    
    <td >
    <label for="destinationDate">Destination Date</label>
    <input type="date" id="destinationDate" name="destinationDate" value="<%= flight.getDestinationDate() %>" readonly="readonly" >
    
    </td>
    
    <td >
    <label for="destinationTime">Destination Time</label>
    <input type="time" id="destinationTime" name="destinationTime" value="<%= flight.getDestinationTime() %>" readonly="readonly" >
    </td>
    
 </tr>
    
    </table>
    <input type="submit" value="Book Ticket">
  </form>
</div>

</body>
</html>
