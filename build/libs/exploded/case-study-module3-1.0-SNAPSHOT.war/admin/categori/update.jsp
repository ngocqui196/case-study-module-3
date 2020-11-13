<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <h2>
                    Edit Categori
                </h2>
            </caption>
            <c:if test="${categori != null}">
                <input type="hidden" name="id" value="<c:out value='${categori.id}'/>"/>
            </c:if>
            <tr>
                <th>Categori Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${categori.name}'/>"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
