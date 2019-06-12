<%--
  Created by IntelliJ IDEA.
  User: 4399
  Date: 2019/6/6
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@include file="_header.jsp" %>
<body>
<div class="container bs-docs-container">
    <form method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Login Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Username" name="name">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<%@include file="_footer.jsp" %>