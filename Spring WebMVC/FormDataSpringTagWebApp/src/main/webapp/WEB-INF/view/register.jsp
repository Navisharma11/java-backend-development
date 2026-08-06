<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
</head>
<body>

<h1 style="color: red; text-align: center;">Registration Application</h1>

<form:form method="post" modelAttribute="emp">
    <table align="center">
        <tr>
            <th>Employee ID</th>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <th>Employee Name</th>
            <td><form:input path="ename"/></td>
        </tr>
        <tr>
            <th>Employee City</th>
            <td><form:input path="ecity"/></td>
        </tr>
        <tr>
            <th>Employee Salary</th>
            <td><form:input path="esalary"/></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;">
                <br/>
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>