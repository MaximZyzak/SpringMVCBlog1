<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 03.11.2020
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:wrapper>
    <br>
    <div class="row justify-content-sm-center">
        <div class="col">
            <a class="btn btn-outline-info btn-sm btn-block" href="/posts/addPost" style="border-width: 1px; border-color: #008080;">Add Post</a>
        </div>
    </div>
    <br>

    <c:forEach var="post" items="${posts}">
        <div class="row justify-content-sm-center bg-dark text-white rounded" style="border-width: 4px; border-color: #008080;   ">
            <div class="col">

                <div class="row justify-content-sm-center">
                    <div class="col">
                    <c:forEach var="user_p" items="${user_post}">
                        <c:if test="${post.post_id == user_p.post_id}">
                            <%--<div class="row justify-content-sm-center">--%>
                            <c:forEach var="user" items="${users}">

                                <c:if test="${user_p.user_id == user.user_id}">

                                    <div class="col">
                                        <span class="badge badge-info">${user.nick_name}</span>
                                    </div>

                                </c:if>

                            </c:forEach>
                            <%--</div>--%>


                        </c:if>

                        <%--button_add_del--%>

                        <c:if test="${post.post_id == user_p.post_id && cur_user == user_p.user_id}">
                            <br>
                            <div class="row justify-content-sm-center">
                            <div class="col">
                                <a class="btn btn-outline-info btn-sm btn-block" href="/posts/delete/${post.post_id}" style="border-width: 1px; border-color: #008080;">Delete</a>
                            </div>

                            <div class="col">
                                <a class="btn btn-outline-info btn-sm btn-block" href="/posts/updatePost/${post.post_id}" style="border-width: 1px; border-color: #008080;">Edit</a>
                            </div>
                            </div>
                            <br>
                        </c:if>

                    </c:forEach>
                    </div>
                </div>


                <div class="col bg-secondary rounded">

                    <div class="row-centered"><span class="post_text"> ${post.title_post} </span></div>
                    <div class="row-centered"><span class="post_id"> <a href=/posts/${post.post_id}><p>${post.post_id}</p></a> </span></div>
                    <br>
                    <div class="row-centered"><span class="post_text"> ${post.post_text} </span></div>
                    <br>
                </div>

                <%-- comment--%>
                <br>

                <%--collapse_button--%>
                <p>
                    <a class="btn btn-primary" data-toggle="collapse" href="#collapseComm${post.post_id}" aria-expanded="false" aria-controls="collapseComm${post.post_id}">
                        Comments
                    </a>
                </p>


                <div class="collapse" id="collapseComm${post.post_id}">

                    <div class="row justify-content-sm-center">
                        <div class="col">

                            <c:forEach var="comment" items="${comments}">

                                <c:if test="${post.post_id == comment.post_id}">
                                <div class="card card-body text-dark">
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

                    <%--addcomment--%>

                    <br>
                    <div class="row justify-content-sm-center">
                        <div class="col">
                            <a class="btn btn-outline-info btn-sm btn-block" href="/posts/${post.post_id}" style="border-width: 1px; border-color: #008080;">Add comment</a>
                        </div>
                    </div>
                    <br>

                </div>

                <%--<div class="row justify-content-sm-center">
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

                </div>--%>

                <%--<div class="row justify-content-sm-center">
                    <div class="col">
                        <a class="btn btn-outline-info btn-sm btn-block" href="" style="border-width: 1px; border-color: #008080;">Add comment</a>
                    </div>
                </div>--%>

            </div>
        </div>

        <br>
    </c:forEach>

</t:wrapper>
