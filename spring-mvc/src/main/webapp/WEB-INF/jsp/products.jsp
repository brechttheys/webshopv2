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
</head>
<body>
<h1>Products</h1>
<table>
<tbody>
<tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Price</th>
    <th>Rating</th>
    <th>&nbsp</th>
</tr>
<c:forEach items="${products}" var="product">
    <tr>
        <td>${product.key}</td>
        <td>${product.value.name}</td>
        <td>${product.value.description}</td>
        <td>${product.value.price}</td>
        <td>${product.value.rating}</td>
        <td><a class="glyphicon glyphicon-edit" href="<c:url value="product/edit/${product.key}.htm"><c:param name="keyvalue" value="${product.key}"/>></c:url>">Edit</a></td>
    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
