<%--
  Created by IntelliJ IDEA.
  User: Brecht
  Date: 8/2/2018
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Basket</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container container-fluid">
    <%@include file="header.jsp"%>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">&nbsp;</th>
            <th scope="col"><spring:message code="products.name" /></th>
            <th scope="col"><spring:message code="products.description" /></th>
            <th scope="col"><spring:message code="products.price" /></th>
            <th scope="col"><spring:message code="products.rating" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${basket}" var="basket">
            <tr>
                <td>${basket.id}</td>
                <td><img src="${basket.poster}"/></td>
                <td>${basket.name}</td>
                <td>${basket.description}</td>
                <td>${basket.price}</td>
                <td>${basket.rating} <span class="glyphicon glyphicon-star"></span></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>