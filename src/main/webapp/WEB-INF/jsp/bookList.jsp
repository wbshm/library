<%--
  Created by IntelliJ IDEA.
  User: 4399
  Date: 2019/6/6
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ include file="_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
欢迎${sessionScope.user.username}访问:
<br>
<table border="1">
    <thead>
    <tr>
        <th>封面</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><img src="${book.cover}" height="60"></td>
            <td>${book.book_name}</td>
            <td>${book.author}</td>
            <td>${book.prize}</td>
            <td>
                <button>更新</button>
                <button>删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@ include file="_footer.jsp" %>
