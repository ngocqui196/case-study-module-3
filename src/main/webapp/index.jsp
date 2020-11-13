<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2020
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" /> <!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->

<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Classic Login Form Responsive Widget,Login form widgets,
 Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,
 Registration Forms,News letter Forms,Elements" />
    <link href="//fonts.googleapis.com/css?family=Oleo+Script:400,700&amp;subset=latin-ext" rel="stylesheet">
  </head>
  <body>
<%--  <script src="js/jquery.vide.min.js"></script>--%>
  <!-- main -->
  <div>
    <div class="center-container">
      <!--header-->
      <div class="header-w3l">
        <h1>Classic Login Form</h1>
      </div>
      <!--//header-->
      <div class="main-content-agile">
        <div class="sub-main-w3">
          <div class="wthree-pro">
            <h2>Login Here</h2>
          </div>
          <form action="/linkkool" method="post">
            <input placeholder="Username" name="account" class="user" type="text">
            <span class="icon1"><i class="fa fa-user" aria-hidden="true"></i></span><br><br>
            <input  placeholder="Password" name="password" class="pass" type="password">
            <span class="icon2"><i class="fa fa-unlock" aria-hidden="true"></i></span><br>
            <div class="sub-w3l">
              <h6><a href="#">Forgot Password?</a></h6>
              <div class="right-w3l">
                <input type="submit" value="Login">
              </div>
            </div>
          </form>
        </div>
      </div>
      <!--//main-->

      <!--footer-->
      <div class="footer">
        <p>&copy; 2017 Classic Login Form. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
      </div>
      <!--//footer-->
    </div>
  </div>

  </body>
</html>
