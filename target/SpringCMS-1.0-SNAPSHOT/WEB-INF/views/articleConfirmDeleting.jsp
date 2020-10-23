<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 22.10.2020
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<p> Chcesz usunąć artykuł ${name}?</p>
<a href="/article/list">WRÓĆ</a>
<a href="/article/delete/${id}">USUŃ</a>

</body>
</html>
