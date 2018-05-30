<%--
  Created by IntelliJ IDEA.
  User: Brecht
  Date: 5/30/2018
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Weather</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div id="container container-fluid">
    <%@include file="header.jsp"%>
    <div class="card">
        <div class="card-header">
            <spring:message code="weather.title" />
        </div>
        <div class="card-body">
            <h5 class="card-title">Leuven</h5>
            <ul>
                <li><spring:message code="weather.temperature" />: <c:out value="${weatherData.main.temp}"/></li>
                <li>Min Temp: <c:out value="${weatherData.main.tempMin}"/></li>
                <li>Max Temp: <c:out value="${weatherData.main.tempMax}"/></li>
                <hr/>
                <li><spring:message code="weather.description" />: <c:out value="${weatherData.weather.get(0).description}"/> <img src="http://openweathermap.org/img/w/<c:out value="${weatherData.weather.get(0).icon}.png"/>"/></li>
                <li><spring:message code="weather.clouds" />: <c:out value="${weatherData.clouds.all}"/></li>
                <hr/>
                <li><spring:message code="weather.degree" />: <c:out value="${weatherData.wind.deg}"/></li>
                <li><spring:message code="weather.speed" />: <c:out value="${weatherData.wind.speed}"/></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
