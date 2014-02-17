<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Kaiser Permanente Login</title>
</head>
<body>
	<center>
		<form name="loginForm" action="LoginController" method="POST">
			<table border=1>
				<tr>
					<th colspan="2">KP Service Calculator Login</th>
				</tr>
				<tr>
					<td>Enter your UserId:</td>
					<td><input type=text name=userId></td>
				</tr>
				<tr>
					<td>Enter your Password:</td>
					<td><input type=password name=pwd></td>
				</tr>
				<tr>
					<td><input type=submit value=submit></td>
					<td><input type=reset value=refresh></td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>