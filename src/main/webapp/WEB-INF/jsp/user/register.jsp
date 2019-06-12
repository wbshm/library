<%--
  Created by IntelliJ IDEA.
  User: 4399
  Date: 2019/6/12
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@include file="../_header.jsp" %>
<body>
<div class="container bs-docs-container">
    <form>
        <div class="form-group">
            <label for="inputName">name</label>
            <input type="text" class="form-control" id="inputName" aria-describedby="name"
                   name="name"
                   placeholder="Enter register name">
            <small id="nameHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="inputAccount">name</label>
            <input type="text" class="form-control" id="inputAccount" aria-describedby="account"
                   name="name"
                   placeholder="Enter register name">
            <small id="accountHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="inputAccount">name</label>
            <input type="number" class="form-control" id="inputAge" aria-describedby="age"
                   name="name"
                   placeholder="Enter register name">
            <small id="ageHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password"
                   placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<%@include file="../_footer.jsp" %>
