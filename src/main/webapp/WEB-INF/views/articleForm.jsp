<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 22.10.2020
  Time: 14:53
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
<form:form modelAttribute="article" method="post" action="${pageContext.request.contextPath}/article/add">
    <p hidden><form:input path="id"/></p>

    <label for="title">title</label>
    <form:input path="title" id="title"/>
    <form:errors path="title"/>

    <label for="content"</label>
    <form:input path="content" id="content"/>
    <form:errors path="content" />


    <form:select path="author.id" items="${authors}" itemValue="id" itemLabel="lastName"/>
    <form:errors path="author.id"/>

    <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id"/>
    <form:errors path="categories"/>

    <form:button type="submit">save</form:button>
</form:form>

</body>
</html>
