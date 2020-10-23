
<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 21.10.2020
  Time: 06:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="button" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<form:form modelAttribute="category" method="post" action="${pageContext.request.contextPath}/category/add">
    <p hidden><form:input path="id"/></p>
    <label for="name">name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>
    <label for="description">Title</label>
    <form:input path="description" id="description"/>
    <form:button type="submit">save</form:button>
</form:form>
</body>
</html>
