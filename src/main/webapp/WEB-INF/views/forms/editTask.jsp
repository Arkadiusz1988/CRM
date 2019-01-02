<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <style>
        .error {
            color: red;
        }
    </style>
    <title>Edit Task</title>
</head>
<body>
<%--@elvariable id="tasks" type="pl.coderslab.entity.Tasks"--%>
<form:form modelAttribute="tasks" method="post">
    New Name
    <br/>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
    <br/><br/>
    New Description:
    <br/>
    <form:input path="description"/>
    <form:errors path="description" cssClass="error"/>
    <br/><br/>
    <input type="submit" value="EDIT">
    <br/><br/>
    <%--<a href="/user/all">Return</a>--%>
</form:form>
</body>
</html>