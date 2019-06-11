<%--
  Created by IntelliJ IDEA.
  User: 4399
  Date: 2019/6/6
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <td><label>登录名</label></td>
            <td><input type="text" id="loginname" name="loginname"></td>
        </tr>
        <tr>
            <td><label>密码</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
        </tr>
    </table>
    <font color="red">${requestScope.message}</font>
</form>
</body>
</html>
