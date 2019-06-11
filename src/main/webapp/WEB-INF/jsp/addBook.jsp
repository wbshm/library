<%--
  Created by IntelliJ IDEA.
  User: wangrq
  Date: 2019/6/9
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<body>
<form action="/springmvc/testMultiUpload2" enctype="multipart/form-data" method="post">
    <input type="text" name="bookName">
    <input type="file" name="img">
    <input type="submit">
</form>
</body>
<%@ include file="_footer.jsp" %>

