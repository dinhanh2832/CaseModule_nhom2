<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 12/5/2021
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1> GIỎ HÀNG</h1>
<table>
    <tr>
        <td> Sản phẩm</td>
        <td> Gía</td>
        <td> Số lượng</td>
    </tr>

        <c:forEach var="i" begin="0" end="${carts.length()-1}">
    <tr>

            <td >${carts.get(i).idProduct}</td>
            <td >${product.price}</td>

        <td><a href="#">Xóa</a></td>
    </tr>
        </c:forEach>

</table>
</center>
</body>
</html>
