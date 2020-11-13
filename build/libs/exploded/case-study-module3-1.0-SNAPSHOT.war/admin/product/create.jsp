<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/10/2020
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/products?action=">List All Products</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Hãy nhập thông tin bạn muốn thêm vào đây</h2>
            </caption>
            <tr>
                <th>ID sản phẩm:</th>
                <td>
                    <input type="text" name="id_product" id="id_product " size="45"/>
                </td>
            </tr>
            <tr>
                <th>Tên sản phẩm:</th>
                <td>
                    <input type="text" name="name_product" id="name_product " size="45"/>
                </td>
            </tr>
            <tr>
                <th>ID loại sản phẩm:</th>
                <td>
                    <input type="text" name="id_categori" id="id_categori" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Giá sản phẩm:</th>
                <td>
                    <input type="text" name="price" id="price" size="15"/>
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
