<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 04.11.2020
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Post</title>
</head>
<body>

<form name="post" action="/posts/updatePost" method="post">
    <input title="Post_id" type="hidden" name="post_id" value="${post.post_id}">
    <p>Title_post </p>
    <input title="Title_post" type="text" name="title_post" value="${post.title_post}">
    <p>Post_text</p>
    <input title="Post_text" type="text" name="post_text" value="${post.post_text}">
    <input type="submit" value="Ok">
</form>

</body>
</html>
