<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <table>
        <tr>
            <td><a href="/categori?action=create">Thêm mới loại sản phẩm</a></td>
                <td><a href="/products?action=">Quay lại danh sách product</a></td>
        </tr>
    </table>
</center>
<div align="center">
    <table border="1" cellpadding="3">
        <caption><h2>Danh sách các loại sản phẩm</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên Loại</th>
        </tr>
        <c:forEach var="categoriList" items="${categori}">
            <tr>
                <td >${categoriList.getId()}</td>
                <td >${categoriList.getName()}</td>
                <td>
                    <a href="/categori?action=edit&id=${categoriList.getId()}">Edit</a>
                    <a href="/categori?action=delete&id=${categoriList.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
