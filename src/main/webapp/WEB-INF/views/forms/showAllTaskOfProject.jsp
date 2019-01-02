<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 31.12.18
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Task of Project</title>
</head>
<body>
<table>
    <c:forEach items="${tasks}" var="tasks">
        <tr>
            <td>Task Name: ${tasks.name} </td>
            <td>Task Description: ${tasks.description} </td>
            <td>Task Creation Date: ${tasks.date} </td>
            <%--<td>Task Owner : ${tasks.project} </td>--%>
            <td><a href="/task/edit/${tasks.id}">Edit tasks</a></td>
            <td><a href="/task/delete/${tasks.id}">Delete tasks</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
