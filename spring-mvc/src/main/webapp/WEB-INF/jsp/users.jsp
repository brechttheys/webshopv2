<%--
  Created by IntelliJ IDEA.
  User: Brecht
  Date: 7/26/2018
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">username</th>
        <th scope="col">first name</th>
        <th scope="col">last name</th>
        <th scope="col">password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.username}</td>
        <td>${user.firstname}</td>
        <td>${user.lastname}</td>
        <td>${user.password} <span class="glyphicon glyphicon-star"></span></td>
    </tr>
    </c:forEach>
</body>
</html>
