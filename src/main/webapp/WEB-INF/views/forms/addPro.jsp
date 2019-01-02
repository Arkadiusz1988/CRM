<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 18.12.18
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dodawanie projektu</title>
</head>
<body>


<div>
    <%--@elvariable id="project" type="pl.coderslab.entity.Project"--%>
    <form:form id="project" modelAttribute="project" method="post">

        <h2>Add project</h2>

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

        <%--<div>--%>
            <%--<form:select path="users">--%>
                <%--<form:option value="" label="*** Wybierz Usera ***" />--%>
                <%--<form:options items="${users}" />--%>
            <%--</form:select>--%>
        <%--</div>--%>

        <div>
        <form:select path="projectPrioEnum">
            <form:option value="" label="*** Wybierz priorytet ***" />
            <form:options items="${projectPrioEnum}" />
        </form:select>
        </div>

        <div>
        <form:select path="projectStatusEnum">
            <form:option value="" label="*** Wybierz Status ***" />
            <form:options items="${projectStatusEnum}" />
        </form:select>
        </div>

        <%--@elvariable id="project" type="pl.coderslab.entity.Project"--%>


        <%--<form:select path="users" items="${users}"--%>
                     <%--itemValue="id" itemLabel="username"/><br/>--%>



        <%--<c:forEach items="${users}" var="users" varStatus="status">--%>
            <%--<tr>--%>
                <%--<td> <form:input id="users" path="users" placeholder="users"/></td>--%>
                <%--&lt;%&ndash;<td><input name="contacts[${status.index}].lastname" value="${users.username}"/></td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td><input name="contacts[${status.index}].email" value="${contact.email}"/></td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>&ndash;%&gt;--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>

        <button name="submit" type="submit">Submit</button>
    </form:form>


</div>

</body>
</html>
