<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 06/12/2021
  Time: 10:42 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <a href="/customers"> back list customer</a>
    <br>
    <br>
    <p> id<input type="text" name="id" value="${customer.getId()}"></p>
    <p> tên khách hàng<input type="text" name="name" value="${customer.getName()}"></p>
    <p> tuổi<input type="text" name="age" value="${customer.getAge()}"></p>
    <p> số đt<input type="text" name="numberPhone" value="${customer.getNumberPhone()}"></p>
    <p> email<input type="text" name="email" value="${customer.getEmail()}"></p>
    <p> số tiền khả dụng<input type="text" name="money" value="${customer.getMoney()}"></p>
    <p> tài khoản<input type="text" name="userNameAcc" value="${customer.getUserNameAcc()}"></p>
    <p> mật khẩu<input type="text" name="pass" value="${customer.getPass()}"></p>
</center>
</body>
</html>
