<%--
  Created by IntelliJ IDEA.
  User: wangrq
  Date: 2019/6/5
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ include file="_header.jsp" %>
<body>
<h3>欢迎来到图书馆系统</h3>
<div class="container bs-docs-container">
    <div class="row justify-content-end">
        <div class="col-3">
            <button class="btn btn-info">登陆</button>
            <button class="btn btn-info" onclick="window.location='/user/register'">注册</button>
        </div>
    </div>
</div>
</body>
<%@ include file="_footer.jsp" %>


