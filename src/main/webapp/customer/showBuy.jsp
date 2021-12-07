<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 12/5/2021
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="UTF-8">
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
<a href="http://localhost:8080/logIn">back</a>
<center>
    <h1> GIỎ HÀNG</h1>

    <table>
        <tr>
            <td> Sản phẩm</td>
            <td> Giá</td>
            <td></td>
        </tr>

        <c:forEach var="i" begin="0" end="${carts.size()-1}">
            <c:if test='${carts.get(i).idProduct != 1}'>
                <tr>
                    <td>${carts.get(i).idProduct}</td>
                    <td>${products.get(i).price}</td>
                    <td><a href="/products?action=deleteCart&id=${carts.get(i).idProduct}&idC=${idC}"
                           onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();}"
                           title="Link Title">
                        Hủy
                    </a></td>
                </tr>
            </c:if>
        </c:forEach>
        <tr>
            <td> Thành tiền</td>

            <td><p> ${total} </p></td>
            <td>
                <form method="post">
                    <input type="hidden" name="ok" value="idC=${idC}">
                    <button>Thanh toán</button>
                </form>
            </td>
        </tr>


    </table>

</center>
</body>
</html>
