<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-size: bkue;
	background-color:white;
	height: 100vh;
}

h1 {
	text-align: center;
	font-family: Tahoma, Arial, sans-serif;
	color: navy;
	margin: 80px 0;
}

.box {
	width: 40%;
	margin: 0 auto;
	background: white;
	padding: 35px;
	border: 2px solid #fff;
	border-radius: 20px/50px;
	background-clip: padding-box;
	text-align: center;
}

.button {
	font-size: 1em;
	padding: 10px;
	color: white;
	border: 2px solid white;
	text-decoration: none;
	cursor: pointer;
	transition: all 0.3s ease-out;
	background: navy;
}

.button:hover {
	background: #111;
}

.overlay {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: #111;
	transition: opacity 500ms;
	visibility: hidden;
	opacity: 0;
}

.overlay:target {
	visibility: visible;
	opacity: 1;
}

.popup {
	margin: 70px auto;
	padding: 20px;
	background: navy;
	border-radius: 5px;
	width: 30%;
	position: relative;
	transition: all 5s ease-in-out;
}

.popup h2 {
	margin-top: 0;
	color: navy;
	font-family: Tahoma, Arial, sans-serif;
}

.popup .close {
	position: absolute;
	top: 20px;
	right: 30px;
	transition: all 200ms;
	font-size: 30px;
	font-weight: bold;
	text-decoration: none;
	color: navy;
}

.popup .close:hover {
	color: navy;
}

.popup .content {
	max-height: 30%;
	overflow: auto;
}

@media screen and (max-width: 700px) {
	.box {
		width: 70%;
	}
	.popup {
		width: 70%;
	}
}
</style>
</head>
<body>
	<h1>Sign Up As</h1>
	<div class="box">
		<a class="button" href="createEmployee.jsp">Employee</a>&nbsp;&nbsp;&nbsp;
	    <a class="button" href="createUser.jsp">&nbsp;&nbsp;&nbsp;&nbsp;User&nbsp;&nbsp;&nbsp;&nbsp;</a>
		
	</div>

	

</body>
</html>