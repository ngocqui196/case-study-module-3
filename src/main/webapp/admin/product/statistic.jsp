<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2020
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thống kê các hoá đơn</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <table border="1">
        <tr>
            <td><a href="/products?action=create">Thêm mới sản phẩm</a></td>
            <td><a href="/products?action=categoriList">Danh sách loại sản phẩm</a></td>
        </tr>
    </table>
</center>
<div align="center">
    <table border="1" cellpadding="3">
        <caption><h2>Danh sách các sản phẩm</h2></caption>
        <tr>
            <th>ID</th>
            <th>Mã loại sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>số lượng</th>
            <th>cỡ</th>
            <th>Giá</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.getCategori().getId()}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.amount}"/></td>
            <td><c:out value="${product.size}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td>
                <a href="/products?action=edit&id=${product.id}">Edit</a>
                <a href="/products?action=delete&id=${product.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
