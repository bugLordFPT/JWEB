<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
	<form action="login" method="post">
		Trainee Account: <input type="text" name="trainee_account"/><br/>
		Password: <input type="password" name="password"><br/>
		<button type="submit">Login</button>
		<button type="reset">Clean</button>
	</form>
</body>
</html>