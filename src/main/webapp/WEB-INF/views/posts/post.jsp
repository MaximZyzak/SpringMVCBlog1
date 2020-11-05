<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 03.11.2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
    <br>
    <div class="row justify-content-sm-center bg-dark text-white rounded">
        <div class="col">

                <div class="row">
                    <p>${post.post_id}</p>
                </div>
                <div class="row">
                    <p>${post.title_post}</p>
                </div>
                <div class="row">
                    <p>${post.post_text}</p>
                </div>


            <br>
            <div class="bg-secondary rounded">
                <div class="row justify-content-sm-center">
                    <div class="col">

                        <c:forEach var="comment" items="${comments}">

                            <c:if test="${post.post_id == comment.post_id}">
                                <div class="bg-info rounded">

                                <c:if test="${cur_user == comment.user_id}">
                                    <div class="row justify-content-sm-end border-dark rounded">
                                        <div class="col-10"></div>
                                        <div class="col">
                                            <a id="btnD${comment.comment_id}" class="btn btn-primary btn-sm" href="/posts/deleteComm/${comment.comment_id}">Delete</a>
                                        </div>

                                        <div class="col">
                                            <a id="btnE${comment.comment_id}" data-toggle="collapse" class="btn btn-primary  btn-sm" href="#collapseEditComm${comment.comment_id}" aria-expanded="false" aria-controls="collapseEdit">Edit</a>
                                        </div>

                                        <div class="collapse" id="collapseEditComm${comment.comment_id}">
                                            <div class="card card-body">
                                                <form name="comment" action="/posts/updateComm/${post.post_id}" method="post">
                                                    <fieldset>
                                                        <div class="form-group">
                                                            <input title="Comment_id" type="hidden" name="comment_id" value="${comment.comment_id}">
                                                            <label for="CommentEdit${comment.comment_id}">Comment</label>
                                                            <textarea title="Comm_text" id="CommentEdit${comment.comment_id}" name="comment_text" cols="80" rows="5" class="form-control">${comment.comment_text}</textarea>
                                                            <input title="Post_id" type="hidden" name="post_id" value="${comment.post_id}">
                                                            <input title="User_id" type="hidden" name="user_id" value="${cur_user}">
                                                        </div>
                                                        <button type="submit" class="btn btn-primary">Edit</button>
                                                    </fieldset>
                                                </form>
                                            </div>
                                        </div>

                                    </div>
                                    <br>
                                </c:if>

                                <div class="row-centered">
                                    <div class="col-2">
                                            ${comment.user_id}
                                    </div>
                                    <div class="col">
                                        <div class="row-centered"><span class="comment-text"> ${comment.comment_text} </span></div>
                                    </div>
                                </div>
                                </div>
                                <br>
                            </c:if>

                        </c:forEach>

                    </div>
                </div>
            </div>
            <br>

            <p>
                <a class="btn btn-primary" data-toggle="collapse" href="#collapseComm" aria-expanded="false" aria-controls="collapseComm">
                    Add comment
                </a>
            </p>


            <div class="collapse" id="collapseComm">

                <div class="row justify-content-sm-center">

                </div>


                <form name="comm" action="/posts/${post.post_id}" method="post">
                    <fieldset>
                        <div class="form-group">
                            <label for="TextInput">Comment</label>
                            <textarea title="Post_text" id="TextInput" name="comment_text" cols="80" rows="5" class="form-control"></textarea>
                            <input title="Post_id" type="hidden" name="post_id" value="${post.post_id}">
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </fieldset>
                </form>
                <br>

            </div>

        </div>
    </div>
    <br>
    <div class="row justify-content-lg-end">
        <a type="button"  class="btn btn-primary btn-lg" href="/posts"> Back </a>
    </div>

</t:wrapper>
