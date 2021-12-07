<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 12/6/2021
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/logIn">back</a>
<center>
    <h1> Hóa đơn </h1>
    <p>${idC}</p>
    <p> ${time}</p>
    <c:forEach var="i" begin="0" end="${products.size()-1}">
        <c:if test='${carts.get(i).idProduct != 1}'>
        <p>${products.get(i).id}</p>
        <p>${products.get(i).price}</p>
        <p>${products.get(i).userProduct}</p>
        <p>${products.get(i).pass}</p>
        </c:if>
    </c:forEach>
    <p> ${total} </p>
</center>


</body>
</html>
