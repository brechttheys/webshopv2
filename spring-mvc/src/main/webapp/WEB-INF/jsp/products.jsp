<%--
  Created by IntelliJ IDEA.
  User: Brecht
  Date: 5/24/2018
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container container-fluid">
<%@include file="header.jsp"%>
<h1><spring:message code="products.title" /></h1>
<table class="table table-dark">
<thead>
<tr>
    <th scope="col">#</th>
    <th scope="col">&nbsp;</th>
    <th scope="col"><spring:message code="products.name" /></th>
    <th scope="col"><spring:message code="products.description" /></th>
    <th scope="col"><spring:message code="products.price" /></th>
    <th scope="col"><spring:message code="products.rating" /></th>
    <th scope="col">&nbsp;</th>
    <th scope="col">&nbsp;</th>
    <th scope="col">&nbsp;</th>
</tr>
</thead>
    <tbody>
<c:forEach items="${products}" var="product">
    <tr>
        <th scope="row">${product.key}</th>
        <td><img src="${product.value.poster}"/></td>
        <td>${product.value.name}</td>
        <td>${product.value.description}</td>
        <td>${product.value.price}</td>
        <td>${product.value.rating} <span class="glyphicon glyphicon-star"></span></td>
        <td><a class="btn btn-primary" href="<c:url value="basket/add/${product.key}.htm"></c:url>">Add to basket</a></td>
        <td><a class="glyphicon glyphicon-edit" href="<c:url value="product/edit/${product.key}.htm"><c:param name="keyvalue" value="${product.key}"/>></c:url>"></a></td>
        <td><a class="glyphicon glyphicon-trash" href="<c:url value="product/delete/${product.key}.htm"></c:url>"></a></td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>
