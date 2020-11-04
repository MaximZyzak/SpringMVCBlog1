<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 03.11.2020
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="post" items="${posts}">
    <tr>
        <td>
            <a href=/posts/${post.id}><p>${post.id}</p></a>
        </td>
        <td>
            <p>${post.post}</p>
        </td>
        <td>
            <p>${post.author}</p>
        </td>
    </tr>
    </c:forEach>
</table>
<%--<c:forEach var="post" items="${posts}">

            <a href=/posts/${post.id}><p>${post.id}</p></a>

            <p>${post.post}</p>


            <p>${post.author}</p>


</c:forEach>--%>
</body>
</html>
