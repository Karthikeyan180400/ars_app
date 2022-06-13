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
<h2>Register Page</h2>

<div class="container">
  <form action="createUser">
    <label for="fname">Name</label>
    <input type="text" id="fname" name="name" placeholder="Enter your name..">
    

    <label for="lname">Email</label>
    <input type="email" id="lname" name="email" placeholder=" Enter your email..">
    
    <label for="lname">Password</label>
    <input type="password" id="lname" name="password" placeholder="Enter your password..">
    
    <p>Gender</p><label class="container">
    <input type="radio"  name="gender" value="male">Male
    <span class="checkmark"></span>
    </label>
    
    <label class="container">
    <input type="radio" name="gender"  value="female">Female
    <span class="checkmark"></span>
    </label><br><br>

    <label for="country">Phone</label>
    <input type="number" id="lname" name="phone" placeholder="Enter your phone number..">
    
  
    <input type="submit" value="Register">
  </form>
</div>

</body>
</html>
