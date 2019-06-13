<%--
  Created by IntelliJ IDEA.
  User: wangrq
  Date: 2019/6/7
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="utf-8" isELIgnored="false"%>
<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css"  href="/static/css/bootstrap.css">
    <script src="/static/js/jquery-3.4.1.min.js"></script>
    <script src="/static/js/bootbox.all.min.js"></script>
    <title>${title}</title>
</head>