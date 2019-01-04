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
    <title>All Tasks of Project</title>
</head>
<body>
<table>
    <c:forEach items="${uploads}" var="uploads">
        <tr>
            <td> File Name: ${uploads.fileName} </td>
            <%--<td>Task Owner : ${tasks.project} </td>--%>
            <td><a href="/retrieve/${uploads.id}">Download a file</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
