
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
        <div class="col-3"></div>
        <div class="col-6">
            <div class="row mt-3">
                <div class="col-12">
                    <a style="width: 150px;margin-left: 230px" class="btn btn-secondary" href="http://localhost:8080/logIn"> Back home</a>
                </div>
            </div>
            <div class="row mt-3">
                <p style="color: white;font-size: 26px;text-align: center">Tài khoản của bạn không đủ tiền! Xin vui lòng nạp thêm tiền để trải nhiệm dịch vụ !!!</p>
            </div>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<hr class="my-2">
<div class="container-fluid padding" style="background: #d5d5d5">
    <div class="row text-center padding">
        <div class="col-12">
            <h2 class="lh">Liên hệ với chúng tôi</h2>
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
                <img  style="margin-top: 10px" src="img/logo.jpg" class="img-fluid">
                <hr class="light">
                <p>000-111-222</p>
                <p>anhnguyen@gmail.com</p>
                <p>binhkk@gmail.com</p>
                <p>dungchimto@gmail.com</p>
                <p>Hoàng Mai- Hà Nội</p>
            </div>
            <div class="col-md-4">
                <hr class="light">
                <p style="font-size: 25px;">Giờ làm việc</p>
                <hr class="light">
                <p>Sáng: 8h-12h</p>
                <p>Chiều: 13h-17h</p>
                <p>Tất cả các ngày trong tuần</p>
                <p>Trừ ngày lễ</p>
                <p>Các bạn có thể liên hệ qua link fb để được hỗ trợ</p>
            </div>
            <div class="col-md-4">
                <hr class="light">
                <p style="font-size: 25px;">Thông tin Web</p>
                <hr class="light">
                <p>Web được thành lập và quản lý bởi</p>
                <img  style="margin-top: 10px" src="img/logo.jpg" class="img-fluid">
                <img  style="margin-top: 10px" src="img/logo.jpg" class="img-fluid">
                <img  style="margin-top: 10px" src="img/logo.jpg" class="img-fluid"> <br>
                Ánh - Dũng - Bình
                <p>Nơi niềm tin và hạnh phúc được gửi gắm</p>
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
