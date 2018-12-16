<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<div>
    <%--@elvariable id="user" type="pl.coderslab.entity.user"--%>
    <form:form id="registerForm" modelAttribute="user" method="post">
        <h3>Register</h3>

        <div>
            <label for="uname">Username</label>
            <form:input id="uname" path="username" placeholder="Username"/>
            <form:errors path="username"/>
        </div>
        <div>
            <label for="pass">Password</label>
            <form:password id="pass" path="password" placeholder="Password"/>
            <form:errors path="password"/>
        </div>
        <div>
            <label for="email">Email</label>
            <form:input id="email" path="email" placeholder="Enter email"/>
            <form:errors path="email"/>
        </div>
        <button name="submit" type="submit">Submit</button>
    </form:form>

    <%@ include file="/WEB-INF/views/fragments/navigation.jspf" %>
</div>

</body>
</html>