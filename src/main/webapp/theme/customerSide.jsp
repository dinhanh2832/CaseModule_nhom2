<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 05/12/2021
  Time: 8:48 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table, th, td{
        border:1px solid #d21d1d;
    }
    table{
        border-collapse:collapse;
        width: 400px;
    }
</style>
<body>
<p>${sessionScope.us}</p>
<center>
    <h1> List Product</h1>
    <br>
    <p><a href="http://localhost:8080/">Đăng xuất</a></p>
    <br>
    <form action="/products">
        <input type="text" name="key" placeholder="Enter name you want find?">
        <button style="background: darkorchid"> find</button>
    </form>
    <form method="get">
        <input type="hidden" name="action" value="sort">
        <button style="background: darkorchid"> Sort</button>
    </form>
    <br>
    <table>
        <tr style="background: pink">

            <td > Id</td>
            <td> Price</td>
            <td> Classify Id</td>
            <td> Server</td>
            <td> Xem</td>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>  <input style="border: none" type="text" name="id" value="${product.id}"></td>
                <td>  <input style="border: none" type="text" name="price" value="${product.price}"></td>
                <td>  <input style="border: none" type="text" name="classifyId" value="${product.classifyId}"></td>
                <td>  <input style="border: none" type="text" name="server" value="${product.serverId}"></td>
                <td><a href="">Xem</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
