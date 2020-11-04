<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 04.11.2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat Post</title>
</head>
<body>
<form name="post" action="/posts/addPost" method="post">
    <p>Title_post </p>
    <input title="Title_post" type="text" name="title_post">
    <p>Post_text</p>
    <input title="Post_text" type="text" name="post_text">
    <input type="submit" value="Ok">
</form>

</body>
</html>
