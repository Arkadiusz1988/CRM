<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 24.12.18
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie zadania do wybranego projektu</title>
</head>
<body>
<h2>Zadanie poprawnie dodane do projektu.</h2>
<br>
<p>Co chcesz zrobic?</p>

<a href="http://localhost:8080/task/addTask">Dodaj kolejne zadanie do projektu</a><br>

<%--<a href="http://localhost:8080/task/showAllTaskOfProject">Wyświetl liste zadan do swojego projektu</a><br>--%>

<a href="http://localhost:8080/project/showAllProjectOfUser">Wyświetl liste twoich projektow</a><br>

<a href="http://localhost:8080/project/addPro">Dodaj kolejny projekt</a><br>

<a href="http://localhost:8080/logout">Wyloguj sie</a><br>


</body>
</html>
