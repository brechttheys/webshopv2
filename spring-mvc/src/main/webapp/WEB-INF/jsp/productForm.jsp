<%--
  Created by IntelliJ IDEA.
  User: Brecht
  Date: 5/24/2018
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container container-fluid">
<%@include file="header.jsp"%>
<form:form modelAttribute="product" method="post" action="${pageContext.request.contextPath}${productAction}">

    <div class="form-group row">
        <form:label path="name" cssClass="control-label"><spring:message code="products.name" /></form:label>
        <form:input path="name"  cssClass="form-control"/>
        <form:errors path="name" cssStyle="color:#f00;"/>
    </div>

    <div class="form-group row">
        <form:label path="description" cssClass="control-label"><spring:message code="products.description" /></form:label>
        <form:input path="description"  cssClass="form-control"/>
        <form:errors path="description" cssStyle="color:#f00;"/>
    </div>

    <div class="form-group row">
        <form:label path="price" cssClass="control-label"><spring:message code="products.price" /></form:label>
        <form:input path="price"  cssClass="form-control"/>
        <form:errors path="price" cssStyle="color:#f00;"/>
    </div>

    <div class="form-group row">
        <form:label path="rating" cssClass="control-label"><spring:message code="products.rating" /></form:label>
        <form:input  path="rating"  cssClass="form-control"/>
        <form:errors path="rating" cssStyle="color:#f00;"/>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="form.save" /></button>

</form:form>
</div>
</body>
</html>
