<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>All yours projects</title>
</head>
<body>
<table>
    <c:forEach items="${projects}" var="projects">
        <tr>
            <td>${projects.name} ${projects.description}</td>
            <td><a href="/project/edit/${projects.id}">Edit Project</a></td>
            <td><a href="/project/delete/${projects.id}">Delete Project</a></td>
            <td><a href="/task/showAllTaskOfProjectById/${projects.id}">Wyświetl liste zadan do swojego projektu</a></td><br>
            <td><a href="/task/addTaskById/${projects.id}">Dodaj zadanie do projektu</a></td><br>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<%--<td><a href="/user/edit/${user.id}">Edit</a></td>--%>
<%--<td><a href="/user/delete/${user.id}">Delete</a></td>--%>