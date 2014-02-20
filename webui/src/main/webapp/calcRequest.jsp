<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Utilization calculation request</title>
</head>
<body>
	<center>
		<form name="requestForm" action="calcController" method="POST">
			<table border=1>
				<tr>
					<th colspan="2">KP Service Calculator Request</th>
				</tr>
				<tr>
					<td>*Start Date:</td>
					<td><input type=text name=startDate></td>
				</tr>
				<tr>
					<td>*End Date:</td>
					<td><input type=text name=endDate></td>
				</tr>
				<!--
				<tr>
					<td>Region:</td>
					<td><input type="text" name=region></td>
				</tr>
				 -->
				<tr>
					<td>Region</td>
					<td>
						<select name="region">
							<option value="NC">NC</option>
							<option value="SC">SC</option>
							<option value="CO">CO</option>
							<option value="other">other</option>
						</select>
					</td>
				</tr>

				<tr>
					<td>Environment Type:</td>
					<td>Prod <input type="radio" name=envType value="Prod">
						Non Prod<input type="radio" name=envType value="NP"></td>
				</tr>
				<tr>
					<td>Number of Environments:</td>
					<td><input type="text" name=envNum></td>
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