<%--
  Created by IntelliJ IDEA.
  User: 4399
  Date: 2019/6/6
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<body>
欢迎${sessionScope.user.username}访问:
<br>
<table border="1">
    <tr>
        <th>封面</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><img src=images/${book.cover} height="60"></td>
            <td>${book.book_name}</td>
            <td>${book.author}</td>
            <td>${book.prize}</td>
        </tr>
    </c:forEach>
</table>
</body>
<%@ include file="_footer.jsp" %>
