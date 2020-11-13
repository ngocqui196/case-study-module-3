
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/4/2020
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seach Product</title>
</head>
<body>
<center>
    <h1>Product management</h1>

</center>
<div align="center">
    <table border="1">
        <caption>
            <h2>
                 List of Product  : <c:out value="${product.getName()}"/>
            </h2>
        </caption>
        <tr>
            <th>ID</th>
            <th>ID Categori</th>
            <th>Name</th>
            <th>Amount</th>
            <th>Size</th>
            <th>Price</th>

        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.getCategori().getId()}"/></td>
                <td><c:out value="${product.getName()}"/></td>
                <td><c:out value="${product.getAmount()}"/></td>
                <td><c:out value="${product.getSize()}"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
