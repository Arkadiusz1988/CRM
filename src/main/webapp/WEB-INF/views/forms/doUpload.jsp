<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 03.01.19
  Time: 01:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRM - Hibernate File Upload</title>
</head>
<body>
<div align="center">
    <h1>CRM - Hibernate File Upload to DB</h1>
    <form method="post" action="doUpload" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>Pick file #1:</td>
                <td><input type="file" name="fileUpload" size="50" /></td>
            </tr>
            <tr>
                <td>Pick file #2:</td>
                <td><input type="file" name="fileUpload" size="50" /></td>
            </tr>
            <tr>
                <td>id projektu ktorego obecnie uzywasz #3:</td>
                <td><input type="text" name="id" value="${id}" size="50" /></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
            </tr>


        </table>
    </form>

</div>
</body>
</html>
