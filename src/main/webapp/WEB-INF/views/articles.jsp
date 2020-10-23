<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 22.10.2020
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>articles</title>
</head>
<body>
<h2> Wszystkie artykuły:</h2>
<c:forEach items="${articles}" var="article">
    <p>
    <h3> ${article.title}</h3>
    ${article.content}
    <p><a href="/article/edit/${article.id}">EDYTUJ ARTYKUŁ</a></p>
    <p><a href="/article/confirm/${article.id}">USUŃ ARTYKUŁ</a></p>
</c:forEach>

<a href="/article/add"><h2>DODAJ ARTYKUŁ</h2></a>

</body>
</html>
