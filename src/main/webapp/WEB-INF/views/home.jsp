<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 17.10.2020
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${articles}" var="article">
   <h1> ${article.title}</h1>
    <p> ${article.created}</p>
    <p> ${article.content}</p>

</c:forEach>

<H2><a href="/category/list">KATEGORIE</a></H2>

<iframe src="https://scratch.mit.edu/projects/436165984/embed" allowtransparency="true" width="485" height="402" frameborder="0" scrolling="no" allowfullscreen></iframe>
</body>
</html>
