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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Posts</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


<c:forEach var="post" items="${posts}">
<div class="row justify-content-sm-center">
    <div class="col">

        <div class="row justify-content-sm-center">

            <c:forEach var="user_p" items="${user_post}">
                <c:if test="${post.post_id == user_p.post_id}">

                    <c:forEach var="user" items="${users}">
                        <c:if test="${user_p.user_id == user.user_id}">

                            <div class="col-2">
                                    ${user.nick_name}
                            </div>

                        </c:if>
                    </c:forEach>

                </c:if>
            </c:forEach>



        </div>


        <div class="row justify-content-sm-center">
            <div class="row-centered"><span class="post_text"> ${post.title_post} </span></div>
            <div class="col-2">
                <div class="row-centered"><span class="post_id"> <a href=/posts/${post.post_id}><p>${post.post_id}</p></a> </span></div>
            </div>

            <div class="col">
                <div class="row-centered"><span class="post_text"> ${post.post_text} </span></div>
            </div>
        </div>

        <div class="row justify-content-sm-center">
            <div class="col">

                <c:forEach var="comment" items="${comments}">

                    <c:if test="${post.post_id == comment.post_id}">
                        <div class="col-2">
                                ${comment.user_id}
                        </div>
                        <div class="col">
                            <div class="row-centered"><span class="comment-text"> ${comment.comment_text} </span></div>
                        </div>
                    </c:if>

                </c:forEach>

            </div>

        </div>

        <div class="row justify-content-sm-center">
            <div class="col">
                <a class="btn btn-outline-info btn-sm btn-block" href="" style="border-width: 1px; border-color: #008080;">Delete</a>
            </div>

            <div class="col">
                <a class="btn btn-outline-info btn-sm btn-block" href="" style="border-width: 1px; border-color: #008080;">Change</a>
            </div>
            <div class="col">
                <a class="btn btn-outline-info btn-sm btn-block" href="" style="border-width: 1px; border-color: #008080;">Add comment</a>
            </div>

        </div>
    </div>
</div>
</c:forEach>

</body>
</html>
