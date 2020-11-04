<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 03.11.2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post</title>
</head>
<body>
<p>${post.post_id}</p>
<p>${post.title_post}</p>
<p>${post.post_text}</p>

<div class="row justify-content-sm-center">
    <div class="col">

        <c:forEach var="comment" items="${comments}">

            <c:if test="${post.post_id == comment.post_id}">
                <div class="row-centered">
                    <div class="col-2">
                            ${comment.user_id}
                    </div>
                    <div class="col">
                        <div class="row-centered"><span class="comment-text"> ${comment.comment_text} </span></div>
                    </div>
                </div>
            </c:if>

        </c:forEach>

    </div>

</div>

</body>
</html>
