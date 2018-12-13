<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR Management Login</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>HR MANAGEMENT</h2>

<form:form action="login"  commandName="loginForm">
	<table cellpadding="5">
		<tr>
			<td>
			<label>User Name :</label>
			<form:errors
				path="userName" />
				</td>
		
		
			<td>
			<span class="inputSpan">* </span>
			<form:input path="userName" maxlength="20"/>
			</td>
		</tr>
		<tr>
			<td><label>Password :</label>
			<form:errors
				path="password" />
				</td>
		
			<td>
			<span class="inputSpan">* </span>
			<form:password path="password" maxlength="25"/>
			</td>
		</tr>
		<tr>
			
			<input type="submit" value="Submit" />
			
			</tr>
		
	</table>
</form:form>
</body>
</html>