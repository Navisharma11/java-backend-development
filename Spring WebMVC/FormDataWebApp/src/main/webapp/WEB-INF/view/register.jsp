<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
</head>
<body>

<h1 style="color: red; text-align: center;">Registration Application</h1>

<form method="post" action="register">
    <table align="center">
        <tr>
            <th>Employee ID</th>
            <td><input type="text" name="id" /></td>
        </tr>
        <tr>
            <th>Employee Name</th>
            <td><input type="text" name="ename" /></td>
        </tr>
        <tr>
            <th>Employee City</th>
            <td><input type="text" name="ecity" /></td>
        </tr>
        <tr>
            <th>Employee Salary</th>
            <td><input type="text" name="esalary" /></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;">
                <br/>
                <input type="submit" value="Register" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>