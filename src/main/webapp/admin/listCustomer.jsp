
<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 04/12/2021
  Time: 8:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Estonia&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/customerSide.css">
</head>
<body>
<center>
    <h1> List Customer</h1>
    <br>
    <p><a href="/logIn?action=page"> Back home</a></p>
    <p><a href="/customers?action=create"> Thêm người dùng</a> </p>
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
            <td> Xem chi tiết</td>
            <td> Id</td>
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
                <td>  <a href="/customers?action=viewCustomer&id=${customer.getId()}">Xem</a></td>
                <td>  <input style="border: none" type="text" name="id" value="${customer.id}"></td>
                <td>  <input style="border: none" type="text" name="name" value="${customer.name}"></td>
                <td>  <input style="border: none" type="text" name="age" value="${customer.age}"></td>
                <td>  <input style="border: none" type="text" name="numberPhone" value="${customer.numberPhone}"></td>
                <td>  <input style="border: none" type="text" name="email" value="${customer.email}"></td>
                <td>  <input style="border: none" type="text" name="money" value="${customer.money}"></td>
                <td>  <input style="border: none" type="text" name="userNameAcc" value="${customer.userNameAcc}"></td>
                <td>  <input style="border: none" type="text" name="pass" value="${customer.pass}"></td>

                <td><a href="/customers?action=edit&id=${customer.getId()}"> Edit</a></td>

                <td> <a href="/customers?action=deleteCus&id=${customer.id}" onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};" title="Link Title">
                    delete
                </a> </td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
