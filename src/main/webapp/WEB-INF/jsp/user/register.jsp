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
    <form method="post" id="registerForm">
        <div class="form-group">
            <label for="inputName">account</label>
            <input type="text" class="form-control" id="inputName" aria-describedby="name"
                   name="account"
                   placeholder="Enter register name">
            <small id="nameHelp" class="form-text text-muted">账号</small>
        </div>
        <div class="form-group">
            <label for="inputAccount">nickname</label>
            <input type="text" class="form-control" id="inputAccount" aria-describedby="account"
                   name="name"
                   placeholder="Enter nickname">
            <small id="accountHelp" class="form-text text-muted">昵称</small>
        </div>
        <div class="form-group">
            <label for="inputAge">age</label>
            <input type="number" class="form-control" id="inputAge" aria-describedby="年龄"
                   name="age"
                   placeholder="Enter age">
        </div>
        <div class="form-group">
            <label for="inputPassword">Password</label>
            <input type="password" class="form-control" id="inputPassword" name="password"
                   placeholder="Password">
        </div>
        <button type="button" class="btn" onclick="history.go(-1)">返回</button>
        <button type="button" class="btn btn-primary submit">Submit</button>
    </form>
</div>
</body>
<script>
    $(".submit").on('click', function () {
        $.ajax({
            url: '/user/register',
            type: 'post',
            dataType: 'json',
            data: $("#registerForm").serialize(),
            success: function (res) {
                if (res === 1) {
                    bootbox.alert(res.msg, function () {
                        $(location).attr('href', '/user/login');
                    });
                }
                bootbox.alert(res.msg);
            }
        });
        return false;
    })
</script>
<%@include file="../_footer.jsp" %>
