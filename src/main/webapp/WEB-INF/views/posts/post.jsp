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
