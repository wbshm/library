<%--
  Created by IntelliJ IDEA.
  User: 4399
  Date: 2019/6/6
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" isELIgnored="false"%>
<%@include file="_header.jsp" %>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <td><label>登录名</label></td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td><label>密码</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
        </tr>
    </table>
    <font color="red">${message}</font>
</form>
</body>
<%@include file="_footer.jsp" %>