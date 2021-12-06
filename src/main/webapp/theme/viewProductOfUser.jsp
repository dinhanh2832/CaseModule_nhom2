<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 12/5/2021
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<%--    <a href="/logIn"> trở lại</a>--%>
    <br>
    <br>
    <p>id<input type="text" name="id1" value="${product.getId()}"></p>
    <p> price<input type="text" name="price" value="${product.getPrice()}"></p>
    <p>classifyId<input type="text" name="classifyId" value="${classifyProduct.category}"></p>
    <p> description<input type="text" name="description" value="${product.getDescription()}"></p>
    <p> userProduct<input type="text" name="userProduct" value="${product.getUserProduct()}"></p>
    <p>pass<input type="text" name="pass" value="${product.getPass()}"></p>
    <p>status<input type="text" name="status" value="${product.getStatus()}"></p>
    <p>serverId<input type="text" name="serverId" value="${server.name}"></p>
</center>
</body>
</html>
