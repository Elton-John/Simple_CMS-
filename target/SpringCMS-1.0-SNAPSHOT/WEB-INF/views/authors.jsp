<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 22.10.2020
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authors</title>
</head>
<body>
<table>
    <tr>

        <th>FIRSTNAME</th>
        <th>LASTNAME</th>

        <th>EDIT</th>
        <th>DELETE</th>

    </tr>
    <c:forEach var="author" items="${authors}">
    <tr>
        <td>${author.firstName}</td>
        <td>${author.lastName}</td>

        <td><a href="edit/${author.id}"> EDIT</a></td>
        <td><a href="confirm/${author.id}"> DELETE</a></td>
    <tr>
        </c:forEach>
</table>

<h1>
    <a href="add">DODAJ  AUTHORA</a>
</h1>
</body>
</html>
