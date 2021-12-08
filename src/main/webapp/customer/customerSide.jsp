<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 05/12/2021
  Time: 8:48 SA
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
                    <a class="nav-link " href="#"><b class="bx">Hướng dẫn</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#"><b class="bx">Nạp thẻ</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#"><b class="bx">${customer.money}</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#"><b class="bx">${sessionScope.name}</b></a>
                </li>
                <img src="img/avtcus.jpg"/>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid mt-2">
    <div class="row">
        <div class="col-3" id="napThe">
            <div class="noi-dung">
                <div class="form">
                    <h2 style="text-align: center">Nạp thẻ ngay</h2>
                    <form action="">
                        <div class="input-form">
                            <span>Nhập số serri</span>
                            <input type="text" name="" style="background-color: white">
                        </div>
                        <div class="input-form">
                            <span>Nhập mã thẻ</span>
                            <input type="password" name="" style="background-color: white">
                        </div>
                        <div class="input-form">
                            <input type="submit" value="Nạp thẻ" style="color: #222222;">
                        </div>
                        <div class="input-form">
                            <p>Bạn gặp phải vấn đề khi nạp thẻ ! <a href="#"> Hỗ trợ nạp</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-7">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/slide1.jpg" class="d-block w-100" alt="..." style="width: 100%;height: 370px">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>First slide label</h5>
                            <p>Some representative placeholder content for the first slide.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/slide2.jpg" class="d-block w-100" alt="..." style="width: 100%;height: 370px">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Second slide label</h5>
                            <p>Some representative placeholder content for the second slide.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/slide3.jpg" class="d-block w-100" alt="..." style="width: 100%;height: 370px">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Third slide label</h5>
                            <p>Some representative placeholder content for the third slide.</p>
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
        <div class="col-2" id="fixMenu">
            <span class="fun" data-toggle="collapse" data-target="#menu"><img src="https://icons.iconarchive.com/icons/kyo-tux/ginux/64/Start-Menu-Run-icon.png" alt="" style="width: 40px; border-radius: 5px;"></span>
            <div class="collapse" id="menu">
                <div class="container-fluid padding">
                    <div class="row text-center">
                        <div class="col-12">
                            <div class="card mb-4" id="ndMenu">
                                <div class="card-body text-center">
                                    <a href="/customers?action=viewCustomer&id=${sessionScope.idC}" class="btn btn-outline-secondary"><b>Tài khoản</b></a>
                                    <a href="/customers?action=edit&id=${sessionScope.idC}" class="btn btn-outline-secondary"><b style="margin-top: -10px;">Đổi mật khẩu</b></a>
                                    <a href="/products?action=showBuy&idP=1&idC=${sessionScope.idC}" class="btn btn-outline-secondary"><b>Giỏ hàng</b></a>
                                    <a href="#" class="btn btn-outline-secondary"><b>Liên hệ</b></a>
                                    <a href="http://localhost:8080" class="btn btn-outline-secondary"><b>Đăng xuất</b></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="jumbotron mt-3">
    <div class="row">
        <div class="col-12">
            <form method="post" id="from" action="/products">
                <select name="price">
                    <option value="0">Chọn theo giá</option>
                    <option value="500000">Dưới 500k</option>
                    <option value="1000000">Dưới 1Tr</option>
                    <option value="1500000">Dưới 1Tr5</option>
                    <option value="2000000">Trên 2Tr</option>
                </select>
                <select name="serverId">
                    <option value="0">Chọn theo Server</option>
                    <option value="1">Server 1</option>
                    <option value="2">Server 2</option>
                    <option value="3">Server 3</option>
                    <option value="4">Server 4</option>
                    <option value="5">Server 5</option>
                    <option value="6">Server 6</option>
                </select>
                <select name="classifyId">
                    <option value="0">Chọn theo độ Vip</option>
                    <option value="1">Acc Vip</option>
                    <option value="3">Acc trung</option>
                    <option value="2">Acc Thường</option>
                </select>
                <button style="height: 40px;width: 100px;">Tìm Kiếm</button>
            </form>
        </div>
    </div>
</div>
<div class="container-fluid mt-2">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-11">
            <div class="row">
                <c:forEach var="i" begin="0" end="${products.size() - 1}">
                    <c:if test='${products.get(i).status != 3}'>
                    <div class="col-3" id="cardproduct">
                        <div class="card mb-4" >
                            <figure class="snip1361" style="width: 242px">
                                <img src="img/logo.jpg" alt="sample45" style="width: 247px">
                                <figcaption>
                                    <h3>Acc số ${products.get(i).id}</h3>
                                    <p>
                                        Giá: ${products.get(i).price} <br>
                                        Loại:  ${classifyProducts.get(i).category} <br>
                                        Server:  ${servers.get(i).name}
                                    </p>
                                </figcaption>
                            </figure>
                            <div class="card-body text-center">
                                <h4 class="card-title"></h4>
                                <a href="/logIn?action=viewProduct&id=${products.get(i).id}" class="btn btn-outline-secondary">Xem thông tin</a>
                                <a href="/products?action=showBuy&idP=${products.get(i).id}&idC=${sessionScope.idC}" class="btn btn-outline-secondary">Mua</a>
                            </div>
                        </div>
                    </div>
                    </c:if>
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
