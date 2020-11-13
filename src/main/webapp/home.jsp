<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2020
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Latest compiled and minified CSS -->


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME-LINK-KOOL</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
    <div class="container" style = "height: auto">
        <header class="row">
            <div class="col-sm-8 shopping-mall">
                <h1>Online shopping mall</h1>
                <h5>The center point of the professional programming</h5>
            </div>
            <img class="col-sm-4" src="webapp/img/img_lights.jpg" />
        </header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home">Trang chủ</span> </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#"><span class="glyphicon glyphicon-home"></span> Đặt bàn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><span class="glyphicon glyphicon-list-alt"></span> Giới thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><span class="glyphicon glyphicon-earphone"></span> Liên hệ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><span class="glyphicon glyphicon-envelope"></span> Góp ý</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><span class="glyphicon glyphicon-question-sign"></span> Hỏi đáp </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <div class = "row">
            <article class="col-sm-9">
            </article>
            <aside class="col-sm-3">
            </aside>
        </div>
        <footer class="card">
            <div class = "card-header text-center">
                <p>CodeGym &copy; 2017</p>
            </div>
        </footer>
    </div>
</body>
</html>
