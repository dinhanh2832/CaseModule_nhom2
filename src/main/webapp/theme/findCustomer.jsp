<%--
  Created by IntelliJ IDEA.
  User: binhd
  Date: 12/6/2021
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
