<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/18
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${admins}" var="admin">
    <tr>
        <td><c:out value="${admin.id}"/></td>
        <td><c:out value="${admin.username}"/></td>
        <td><c:out value="${admin.password}"/></td>
        <td><a href="delete?id= <c:out value="${admin.id}"/>">del</a></td>
    </tr>
</c:forEach>
</body>
</html>
