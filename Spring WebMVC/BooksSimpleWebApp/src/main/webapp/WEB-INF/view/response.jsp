<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--here we added that taglib prefix c= to use the prefic 'c' for looping--%>
<html>
<head>
    <title> Response Page</title>
</head>
<body>

<center>

    <h1>Displaying data from an Array/Collection</h1>
    <h1 style="color: blue;text-align: center"></h1>
    <%--    now here if we want to interate over the collection recieved from the getBooksInfo method mapped with the /response endpoint, for that we have to add the JSTL libraries--%>
    <%--    this below line is same as for each loop where we have to add the key in the items field,and just like the foreach loop we have to take variable simply here we did that by var=booksName--%>
    <c:forEach var="booksName" items="${books}">${booksName}</c:forEach>

</center>

</body>
</html>