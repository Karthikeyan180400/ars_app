<!DOCTYPE html>
<%@page import="com.ty.arsapp.service.impl.UserServiceImp"%>
<%@page import="com.ty.arsapp.dto.User"%>
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
<h2>Search Flight</h2>

<% HttpSession httpSession = request.getSession();
   String email = (String)httpSession.getAttribute("email");
   String password = (String)httpSession.getAttribute("password");
   UserServiceImp userServiceImp = new UserServiceImp();
   User user = userServiceImp.validateUser(email, password);
%>

<% if(user != null) { %>
<div class="container">
  <form action="searchFlight">
  <table>
  <tr>
    <td >
    Departure<select name="departure">
    <option value="" style="opacity: 0.4">From</option>
    <option value="Bangalore">Bangalore</option>
    <option value="Chennai">Chennai</option>
    <option value="Mumbai">Mumbai</option>
    <option value="Trichy">Trichy</option>
    </select>
    </td>
    
    <td >
    <label for="departureDate">Departure Date</label>
    <input type="date" id="departureDatelname" name="departureDate">
    </td>
  </tr> 
  
  <tr>
    
    <td >
    Destination<select name="destination">
    <option value="" style="opacity: 0.4">To</option>
    <option value="Bangalore">Bangalore</option>
    <option value="Chennai">Chennai</option>
    <option value="Mumbai">Mumbai</option>
    <option value="Trichy">Trichy</option>
    </select>
    </td>
    
    <td >
    <label for="destinationDate">Destination Date</label>
    <input type="date" id="destinationDate" name="destinationDate" >
    
    </td>
    </tr> 
    
    </table>
    
    <input type="submit" value="Search Flight">
  </form>
</div>

<% } %>
</body>
</html>
