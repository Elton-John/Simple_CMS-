
<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 22.10.2020
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>author</title>
</head>
<body>
<form:form modelAttribute="author" method="post" action="${pageContext.request.contextPath}/author/add">
    <p hidden><form:input path="id"/></p>
    <form:input path="firstName"/>
    <form:errors path="firstName"/>
    <form:input path="lastName"/>
    <form:errors path="lastName"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
