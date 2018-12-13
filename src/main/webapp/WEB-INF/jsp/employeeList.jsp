<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee management</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
                    rel="stylesheet">
</head>
    <body>
    <h1>Welcome ${user}</h1>
    <h3><a href="./newContact">Add New Employee</a></h3>
    <div class="container">
        <table border="1" cellpadding="15" bgcolor="#f9efdf" align="center">
            <caption><h3>Employees</h3></caption>
            <thead>
                <tr class="tr tr-success">
                    <td>Employee Code</td>
                    <td>Employee Name</td>
                    <td>Location</td>
                    <td>Email</td>
                    <td>Date Of Birth</td>
                </tr>   
            </thead>
            <tbody>
                <c:forEach items="${inf}" var="temp">
                    <tr>
                        <td>${temp.code}</td>
                        <td>${temp.name}</td>
                        <td>${temp.location}</td>
                        <td>${temp.email}</td>
                        <td>${temp.dob}</td>
                        <td><a href="./editContact?code=${temp.code}">Edit</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>