<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 21.10.2020
  Time: 06:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>categories</title>
</head>
<body>
<h2> Wszystkie kategorie:</h2>
<c:forEach items="${categories}" var="category">
    <p>
    <h3> ${category.name}</h3>
    ${category.description}
    <p> <a href="/category/edit/${category.id}">EDYTUJ KATEGORIĘ</a> </p>
    <p> <a href="/category/confirm/${category.id}">USUŃ KATEGORIĘ</a> </p>
</c:forEach>

<a href="/category/add"><h2>DODAJ KATEGORIĘ</h2></a>
</body>
</html>
