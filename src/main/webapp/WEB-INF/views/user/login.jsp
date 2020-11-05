<%--
  Created by IntelliJ IDEA.
  User: MAXIMUS
  Date: 05.11.2020
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>


    <form class="form-signin" name="user" action="/" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="text" id="inputLogin" class="form-control" name="nick_name" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</t:wrapper>
