<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 24.12.18
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Task</title>
</head>
<body>

<%--@elvariable id="task" type="pl.coderslab.entity.Tasks"--%>
<form:form id="task" modelAttribute="task" method="post">

    <h2>Add Task</h2>

    <h3> you are logged as ${userLogged}</h3>

    <div>
        <label for="name">Name</label>
        <form:input id="name" path="name" placeholder="name"/>
        <form:errors path="name"/>
    </div>
    <div>
        <label for="description">Description</label>
        <form:input id="description" path="description" placeholder="description"/>
        <form:errors path="description"/>
    </div>


    <button name="submit" type="submit">Submit</button>
</form:form>


</body>
</html>
