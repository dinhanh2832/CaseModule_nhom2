
<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 12/4/2021
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table, th, td {
        border: 1px solid #d21d1d;
    }

    table {
        border-collapse: collapse;
        width: 400px;
    }
</style>
<body>
<center>
    <h1> List Product</h1>
    <br>
    <p><a href="/products?action=create"> Create product</a></p>
    <p><a href="/logIn?action=page">Back home</a></p>
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
            <td> Xem chi tiết</td>
            <td> Id</td>
            <td> Price</td>
            <td> Classify Id</td>
            <td> Server</td>

            <td> Edit</td>
            <td> Delete</td>
        </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><a href="/products?action=view&id=${product.getId()}"> Xem chi tiết</a></td>
                    <td><input style="border: none" type="text" name="id" value="${product.id}"></td>
                    <td><input style="border: none" type="text" name="price" value="${product.price}"></td>
                    <td><input style="border: none" type="text" name="classifyId" value="${product.classifyId}"></td>
                    <td><input style="border: none" type="text" name="server" value="${product.serverId}"></td>

                    <td><a href="/products?action=edit&id=${product.getId()}"> Edit</a></td>

                    <td><a href="/products?action=delete&id=${product.id}"
                           onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};"
                           title="Link Title">
                        delete
                    </a></td>
                </tr>
            </c:forEach>
    </table>
</center>
</body>
</html>
