
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Tien Dung--%>
<%--  Date: 12/4/2021--%>
<%--  Time: 4:34 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<style>--%>
<%--    table, th, td {--%>
<%--        border: 1px solid #d21d1d;--%>
<%--    }--%>

<%--    table {--%>
<%--        border-collapse: collapse;--%>
<%--        width: 400px;--%>
<%--    }--%>
<%--</style>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h1> List Product</h1>--%>
<%--    <br>--%>
<%--    <p><a href="/products?action=create"> Create product</a></p>--%>
<%--    <p><a href="/logIn?action=page">Back home</a></p>--%>
<%--    <br>--%>
<%--    <form action="/products">--%>
<%--        <input type="text" name="key" placeholder="Enter name you want find?">--%>
<%--        <button style="background: darkorchid"> find</button>--%>
<%--    </form>--%>
<%--    <form >--%>
<%--        <input type="hidden" name="action" value="sortProduct">--%>
<%--        <button style="background: darkorchid"> Sort</button>--%>
<%--    </form>--%>


<%--    <br>--%>
<%--    <table>--%>
<%--        <tr style="background: pink">--%>
<%--            <td> Xem chi tiết</td>--%>
<%--            <td> Id</td>--%>
<%--            <td> Price</td>--%>
<%--            <td> Classify Id</td>--%>
<%--            <td> Server</td>--%>

<%--            <td> Edit</td>--%>
<%--            <td> Delete</td>--%>
<%--        </tr>--%>
<%--            <c:forEach  var="i" begin="0" end="${products.size() - 1}">--%>
<%--                <tr>--%>
<%--                    <td><input style="border: none" type="text" name="id" value=""></td>--%>
<%--                    <td><input style="border: none" type="text" name="price" value=""></td>--%>
<%--                    <td><input style="border: none" type="text" name="classifyId" value=""></td>--%>
<%--                    <td><input style="border: none" type="text" name="server" value=""></td>--%>

<%--                    <td><a href=""> Edit</a></td>--%>

<%--                    <td></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--    </table>--%>
<%--</center>--%>
<%--</body>--%>
<%--</html>--%>
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
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top ">
    <div class="container-fluid">
        <a class="navbar-branch" href="#">
            <img src="img/logo.jpg">
        </a>
        <h1 class="nameLogo">ADB Shop</h1>
        <button class="navbar-toggler" type="button" data-toggler="collapse"
                data-target="#navbarResponsiver">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsiver">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a target="_self" data-target="fa-home" class="nav-link active" href="#" title="Home">
                        <i class="fa fa-home"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#"><b class="bx">Trung tâm</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#"><b class="bx">Admin</b></a>
                </li>
                <img src="img/avtcus.jpg"/>
                <li class="nav-item">
                    <a class="nav-link " href="http://localhost:8080"><b class="bx">Đăng xuất</b></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<img src="img/anhnendangnhap.jpg" class="img-fluid">
<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-11">
            <div class="row mt-3">
                <div class="col-8">
                    <a class="btn btn-outline-secondary" href="/logIn?action=page"  > Back home</a>
                    <a class="btn btn-outline-secondary" href="/products?action=create" > Thêm Acc</a>
                </div>
                <div class="col-4">
                    <form method="post" action="/products?action=searchAD">
                        <input type="text" name="idProduct" placeholder="Nhập mã số Acc">
                        <button>Tìm Kiếm</button>
                    </form>
                </div>
            </div>
            <div class="row mt-3">
                <c:forEach  var="i" begin="0" end="${products.size() - 1}">
                    <div class="col-3" id="cardproduct">
                        <div class="card mb-4">
                            <figure class="snip1361" style="width: 242px">
                                <img src="img/logo.jpg" alt="sample45" style="width: 247px">
                                <figcaption>
                                    <h3>Acc số ${products.get(i).id}</h3>
                                    <p>
                                        Giá: ${products.get(i).price} <br>
                                        Loại: ${classifyProducts.get(i).category}, server ${servers.get(i).name}
                                    </p>
                                </figcaption>
                            </figure>
                            <div class="card-body text-center">
                                <h4 class="card-title"></h4>
                                <a href="/products?action=view&id=${products.get(i).id}"
                                   class="btn btn-outline-secondary">Xem</a>
                                <a href="/products?action=edit&id=${products.get(i).getId()}"
                                   class="btn btn-outline-secondary">Sửa</a>
                                <a href="/products?action=delete&id=${products.get(i).id}"
                                   class="btn btn-outline-secondary"
                                   onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};"
                                   title="Link Title">
                                    Xóa
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<hr class="my-2">
<div class="container-fluid padding" style="background: white">
    <div class="row text-center padding">
        <div class="col-12">
            <h2>Liên hệ với chúng thôi</h2>
        </div>
        <div class="col-12 social padding">
            <a href="#"><i class="fab fa-facebook"></i></a>
            <a href="#"><i class="fab fa-twitter"></i></a>
            <a href="#"><i class="fab fa-google-plus-g"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
            <a href="#"><i class="fab fa-youtube"></i></a>
        </div>
    </div>
</div>
<footer>
    <div class="container-fluid padding">
        <div class="row text-center">
            <div class="col-md-4">
                <img src="img/logo.jpg" class="img-fluid">
                <hr class="light">
                <p>000-111-222</p>
                <p>anhnguyen@gmail.com</p>
                <p>Hoàng Mai- Hà Nội</p>
            </div>
            <div class="col-md-4">
                <hr class="light">
                <p>Giờ làm việc</p>
                <hr class="light">
                <p>Sáng: 8h-12h</p>
                <p>Chiều: 13h-17h</p>
            </div>
            <div class="col-md-4">
                <hr class="light">
                <p>000-111-222</p>
                <hr class="light">
                <p>anhnguyen@gmail.com</p>
                <p>Hoàng Mai- Hà Nội</p>
            </div>
            <div class="col-12">
                <hr class="light-100">
                <h5 class="ba">&copy;ADBShop</h5>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
