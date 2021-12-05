
<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 04/12/2021
  Time: 8:10 CH
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
<center>
    <h1> List Customer</h1>
    <br>
    <p><a href="/logIn?action=page"> Back home</a></p>
    <p><a href="/products?action=create"> Thêm người dùng</a> </p>
    <br>
    <form action="/customers">
        <input type="text" name="key" placeholder="Enter name you want find?">
        <button style="background: darkorchid"> find</button>
    </form>
    <form>
        <input type="hidden" name="action" value="sort">
        <button style="background: darkorchid"> Sort</button>
    </form>
    <br>
    <table>
        <tr style="background: pink">

            <td > Id</td>
            <td> Tên khách hàng</td>
            <td> Tuổi</td>
            <td> Số điện thoại</td>
            <td> Email</td>
            <td> Số tiền khả dụng</td>
            <td> Tài khoản</td>
            <td> Mật khẩu</td>
            <td> Edit</td>
            <td> Delete</td>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>  <input style="border: none" type="text" name="id" value="${customer.id}"></td>
                <td>  <input style="border: none" type="text" name="name" value="${customer.name}"></td>
                <td>  <input style="border: none" type="text" name="age" value="${customer.age}"></td>
                <td>  <input style="border: none" type="text" name="numberPhone" value="${customer.numberPhone}"></td>
                <td>  <input style="border: none" type="text" name="email" value="${customer.email}"></td>
                <td>  <input style="border: none" type="text" name="money" value="${customer.money}"></td>
                <td>  <input style="border: none" type="text" name="userNameAcc" value="${customer.userNameAcc}"></td>
                <td>  <input style="border: none" type="text" name="pass" value="${customer.pass}"></td>

                <td><a href="/customers?action=edit&id=${customer.getId()}"> Edit</a></td>

                <td> <a href="/customers?action=delete&id=${customer.id}" onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};" title="Link Title">
                    delete
                </a> </td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
