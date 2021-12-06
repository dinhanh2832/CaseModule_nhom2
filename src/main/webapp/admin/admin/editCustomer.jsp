<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 04/12/2021
  Time: 9:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers">Back show Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
                <th>Tên người dùng:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tuổi:</th>
                <td>
                    <input type="text" name="age" size="15"
                           value="<c:out value='${customer.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="numberPhone" size="25"
                           value="<c:out value='${customer.numberPhone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email :</th>
                <td>
                    <input type="text" name="email" size="85"
                           value="<c:out value='${customer.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số tiền khả dụng:</th>
                <td>
                    <input type="text" name="money" size="25"
                           value="<c:out value='${customer.money}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tài khoản:</th>
                <td>
                    <input type="text" name="userNameAcc" size="25"
                           value="<c:out value='${customer.userNameAcc}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Mật khẩu:</th>
                <td>
                    <input type="text" name="pass" size="25"
                           value="<c:out value='${customer.pass}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

