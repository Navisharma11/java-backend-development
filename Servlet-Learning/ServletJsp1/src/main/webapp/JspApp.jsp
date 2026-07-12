<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP WEB APP</title>
</head>
<body>
<h1>JSP Web App to generate Dynamic Response</h1>

<%@    page import="java.util.Date"


 %>



<%!

     int age = 18;
     int agee = 20;

%>




<%

String name = request.getParameter("uname");
String ucity = request.getParameter("ucity");

Date date = new Date();

//out.println(date);

out.println("Hello " + name);
//out.println("I know you're from "+ucity);

%>

<h1><%= date %></h1>
<h2>Hello I know you're from <%= ucity %></h2>
<h2>Hello I know your age is <%= age %></h2>
<h2>Hello I know your age is <%= agee %></h2>


</body>
</html>