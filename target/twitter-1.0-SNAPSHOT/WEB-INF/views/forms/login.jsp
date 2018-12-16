<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>


<%--@elvariable id="user" type="pl.coderslab.entity.user"--%>
<div>
    <form:form modelAttribute="user" method="post">
        <h3>Log in</h3>
        <div>
            <label for="email">Email</label>
            <form:input id="email" path="email" placeholder="Enter email"/>
        </div>
        <div>
            <label for="pass">Password</label>
            <form:password id="pass" path="password" placeholder="password"/>
        </div>
        <button name="submit" type="submit">Log in</button>

        <div>
            <form:errors path="*"/>
        </div>
    </form:form>


    <ul>
        <li>
            <a href=${pageContext.request.contextPath}/register>Register</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/login">Log in</a>
        </li>
    </ul>

</div>
</body>
</html>
