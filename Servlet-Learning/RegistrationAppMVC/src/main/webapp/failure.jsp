<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failure</title>
</head>
<body>
<h1><marquee>Registration Failed</marquee></h1>
<% String name = (String)session.getAttribute("name");   %>
<h2>Hey<%= name %>, you failed to registered to this webApp</h2>
</body>
</html>