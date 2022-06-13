<!DOCTYPE html>
<%@page import="com.ty.arsapp.dto.User"%>
<%@page import="com.ty.arsapp.dto.Employee"%>
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

input[type=submit] {
  width: 100%;
  background-color: navy;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #111;
}

div.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>
<%@include file="userNaviBar.jsp" %>
<h2>Profile Details</h2>
           <%
              User user = (User)request.getAttribute("user");
			%>


<div class="container">
  <form action="">
  <a href="updateUser.jsp?id=<%= user.getId() %>">Update</a>&nbsp;&nbsp;&nbsp;
  <a href="deleteUser?id=<%= user.getId() %>">Delete</a><br><br>
  
    <label for="fname">ID</label>
    <input type="text" id="fname" name="id" placeholder="Enter your name.." value="<%= user.getId()%>" readonly="readonly">
  
    <label for="fname">Name</label>
    <input type="text" id="fname" name="name" placeholder="Enter your name.." value="<%= user.getName() %>" readonly="readonly">
    

    <label for="lname">Email</label>
    <input type="email" id="lname" name="email" placeholder=" Enter your email.." value="<%= user.getEmail() %>" readonly="readonly">
    
    <label for="lname">Password</label>
    <input type="password" id="lname" name="password" placeholder="Enter your password.." value="<%= user.getPassword() %>" readonly="readonly">
    
    <label for="lname">Gender</label>
    <input type="text" id="lname" name="gender" placeholder="Enter your password.." value="<%= user.getGender() %>" readonly="readonly">

    <label for="country">Phone</label>
    <input type="number" id="lname" name="phone" placeholder="Enter your phone number.." value="<%= user.getPhone() %>" readonly="readonly">
    
  
    
  </form>
</div>

</body>
</html>
