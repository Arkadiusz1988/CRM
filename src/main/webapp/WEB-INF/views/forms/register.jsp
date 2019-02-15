<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div style="width: 400px;height: 500px;margin: auto;position: absolute;top: 0;    bottom: 0;    left: 0;    right: 0;    max-width: 100%;    max-height: 100%;    overflow: auto;">

    <%--@elvariable id="user" type="pl.coderslab.entity.user"--%>
    <form:form class="form-group" id="registerForm" modelAttribute="user" method="post">
        <h3>Register</h3>

        <div>
            <label for="uname">Username</label>
            <form:input class="form-control" id="uname" path="username" placeholder="Username"/>
            <form:errors path="username"/>
        </div>
        <div>
            <label for="pass">Password</label>
            <form:password class="form-control" id="pass" path="password" placeholder="Password"/>
            <form:errors path="password"/>
        </div>
        <div>
            <label for="email">Email</label>
            <form:input class="form-control" id="email" path="email" placeholder="Enter email"/>
            <form:errors path="email"/>
        </div>
        <button name="submit" class="btn btn-primary" type="submit">Submit</button>
    </form:form>

    <%@ include file="/WEB-INF/views/fragments/navigation.jspf" %>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>