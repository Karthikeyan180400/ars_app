<!DOCTYPE html>
<%@page import="com.ty.arsapp.service.impl.EmployeeServiceImp"%>
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


           <%
              EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
			  Employee employee = employeeServiceImp.getEmployeeById(Integer.parseInt(request.getParameter("id")));
			%>

<% if(employee.getRole().equals("Admin")){ %>

<%@include file="adminNaviBar.jsp" %>
<h2>Update Your Profile Details</h2>
<div class="container">
  <form action="updateEmployee">
  
    <label for="fname">ID</label>
    <input type="text" id="fname" name="id" placeholder="Enter your name.." value="<%= employee.getId()%>" readonly="readonly">
  
    <label for="fname">Name</label>
    <input type="text" id="fname" name="name" placeholder="Enter your name.." value="<%= employee.getName() %>">
    
    <label for="fname">Role</label>
                    <select name="role">
                            <option value="<%= employee.getRole() %>">"<%= employee.getRole() %>"</option>
							<option value="Admin">Admin</option>
							<option value="Executive">Executive</option>
					</select>
    <input type="text" id="fname" name="role" placeholder="Enter your role.." value="<%= employee.getRole() %>">

    <label for="lname">Email</label>
    <input type="email" id="lname" name="email" placeholder=" Enter your email.." value="<%= employee.getEmail() %>">
    
    <label for="lname">Password</label>
    <input type="password" id="lname" name="password" placeholder="Enter your password.." value="<%= employee.getPassword() %>">
    
    <p>Gender</p><label class="container">Male
    <input type="radio"  name="gender" value="male">
    <span class="checkmark"></span>
    </label>
    
    <label class="container">Female
    <input type="radio" name="gender"  value="female">
    <span class="checkmark"></span>
    </label><br><br>

    <label for="country">Phone</label>
    <input type="number" id="lname" name="phone" placeholder="Enter your phone number.." value="<%= employee.getPhone() %>">
    
    <input type="submit" value="Update">
    
  </form>
</div>
<% } else if(employee.getRole().equals("Executive")){ %>

<%@include file="executiveNaviBar.jsp" %>
<h2>Update Your Profile Details</h2>
<div class="container">
  <form action="updateEmployee">
  
    <label for="fname">ID</label>
    <input type="text" id="fname" name="id" placeholder="Enter your name.." value="<%= employee.getId()%>" readonly="readonly">
  
    <label for="fname">Name</label>
    <input type="text" id="fname" name="name" placeholder="Enter your name.." value="<%= employee.getName() %>">
    
    <label for="fname">Role</label>
    <input type="text" id="fname" name="role" placeholder="Enter your role.." value="<%= employee.getRole() %>">

    <label for="lname">Email</label>
    <input type="email" id="lname" name="email" placeholder=" Enter your email.." value="<%= employee.getEmail() %>">
    
    <label for="lname">Password</label>
    <input type="password" id="lname" name="password" placeholder="Enter your password.." value="<%= employee.getPassword() %>">
    
    <p>Gender</p><label class="container">Male
    <input type="radio"  name="gender" value="male">
    <span class="checkmark"></span>
    </label>
    
    <label class="container">Female
    <input type="radio" name="gender"  value="female">
    <span class="checkmark"></span>
    </label><br><br>

    <label for="country">Phone</label>
    <input type="number" id="lname" name="phone" placeholder="Enter your phone number.." value="<%= employee.getPhone() %>">
    
    <input type="submit" value="Update">
    
  </form>
</div>
<% } %>

</body>
</html>
