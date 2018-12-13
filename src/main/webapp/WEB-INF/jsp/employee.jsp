<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Contact</h1>
        <form:form action="saveEmployee" method="post" commandName="employee">
        <table>
            
            <tr>
                <td>Employee Code:</td>
                <td><form:input path="code" /></td>
                <td>Can't change for editing</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Location:</td>
                <td><form:input path="location" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Date Of Birth:</td>
                <td><form:input path="dob" /></td>
            </tr>
            <tr>
                <td>Manager:</td>
                <td><form:input path="manager" /></td>
                <td>Can't change for editing</td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>