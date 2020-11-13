<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới loại sản phẩm</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/categori?action=">List Categori</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Categori</h2>
            </caption>
            <tr>
                <th>Categori id:</th>
                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Categori Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
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
