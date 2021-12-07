<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 03/12/2021
  Time: 11:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
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
    <link rel="stylesheet" href="css/index.css">
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
                    <a target="_self" data-target="fa-home" class="nav-link active" href="http://localhost:8080" title="Home">
                        <i class="fa fa-home"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#"><b class="bx">Service</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#"><b class="bx">Team</b></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<img src="img/anhnendangnhap.jpg" class="img-fluid">
<div class="jumbotron ">
    <div class="row">
        <div class="col-12">
            <p class="bp">Web Acc <b class="bb">Cửu âm</b> hàng đầu Việt Nam <br>
                Chuyên nghiệp và nhanh chóng<br>
                Uy tín làm nên chất lượng
            </p>
        </div>
    </div>
</div>
<div class="container-fluid ">
    <div class="row">
        <div class="col-6">
            <div class="col-1"></div>
            <div class="col-11">
                <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="4"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="5"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img  src="img/clc.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5 class="bhp">Cực Lạc Cốc</h5>
                                <p class="bhp">Sức tấn công mạnh mẽ, linh hoạt</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="img/cyv.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5 class="bhp">Cẩm y vệ</h5>
                                <p class="bhp">Sức chống chịu đỉnh cao,phòng thủ kiên cố</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="img/vd.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5 class="bhp">Võ Đang</h5>
                                <p class="bhp">Hồi phục siêu phàm,vượt ải thần sầu</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="img/my.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5 class="bhp">Nga My</h5>
                                <p class="bhp">Kỹ năng khống chế tuyệt đỉnh,hỗ trợ tốt</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="img/dm.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5 class="bhp">Đường Môn</h5>
                                <p class="bhp">Vua của các loại độc, cấu rỉa tốt</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="img/cb.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5 class="bhp">Cái Bang</h5>
                                <p class="bhp">Lực phòng thủ tốt, tấn công mạnh mẽ và nhanh gọn</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-target="#carouselExampleCaptions"
                            data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-target="#carouselExampleCaptions"
                            data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-6">
            <p>
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>
            <form method="post" action="/logIn">
            <div class="noi-dung">
                <div class="form">
                    <h2>Trang Đăng Nhập</h2>
                    <form action="">
                        <div class="input-form">
                            <span>Tên Người Dùng</span>
                            <input type="text" name="username" placeholder="username" />
                        </div>
                        <div class="input-form">
                            <span>Mật Khẩu</span>
                            <input type="password" name="password" placeholder="password" />
                        </div>
                        <div class="nho-dang-nhap">
                            <label><input type="checkbox" name=""> Nhớ Đăng Nhập</label>
                        </div>
                        <div class="input-form">
                            <input type="submit" value="Đăng Nhập" style="color: #222222;">
                        </div>
                        <div class="input-form">
                            <p>Bạn Chưa Có Tài Khoản? <a href="/customers?action=create">Đăng Ký</a><a href="" style="color: #3f3f3f">    Mua Ngay</a></p>
                        </div>

                    </form>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>
<hr class="my-2">
<div class="container-fluid padding">
    <div class="row text-center padding">
        <div class="col-12">
            <h2 class="bl">Liên hệ với chúng thôi</h2>
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
<footer >
    <div class="container-fluid padding">
        <div class="row text-center" >
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

