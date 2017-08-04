<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BKJCB
  Date: 2017/8/2
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H2>Hellow ${name}</H2>
<table border="1">
    <tr>
        <th>姓名</th>
        <td>密码</td>
    </tr>
    <c:forEach var="student" items="${list}">
        <tr>
            <td>${student.name}</td>
            <td>${student.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
<!-- jQuery -->
<script src="../../js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../js/bootstrap.min.js"></script>
</html>
