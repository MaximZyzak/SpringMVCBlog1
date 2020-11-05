<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 04.11.2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    <form name="post" action="/posts/addPost" method="post">
        <p>Title_post </p>
        <input title="Title_post" type="text" name="title_post">
        <p>Post_text</p>
        <textarea title="Post_text" name="post_text" cols="40" rows="10"></textarea>
        <input type="submit" value="Ok">
    </form>

</t:wrapper>




