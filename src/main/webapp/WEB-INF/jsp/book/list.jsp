<%--
  Created by IntelliJ IDEA.
  User: 4399
  Date: 2019/6/6
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ include file="../_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
欢迎${username}访问:
<br>
<table class="table">
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
        <tr data-bid="${book.id}">
            <td><img src="${book.cover}" height="60"></td>
            <td>${book.book_name}</td>
            <td>${book.author}</td>
            <td><input class="form-control" type="number" name="prize" value="${book.prize}"></td>
            <td>
                <button class="btn btn-success book-update">更新</button>
                <button class="btn btn-danger book-delete">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script>
    $(".book-update").on('click', function () {
        const _tr = $(this).parents("tr");
        console.log("点击了");
        $.ajax({
            url    : '/book/' + _tr.attr('data-bid'),
            method : 'POST',
            type   : 'json',
            data   : {prize: _tr.find("input[name='prize']").val()},
            success: function (rtn) {
                if (rtn.code == '1') {
                    _tr.find("input[name='prize']").val(rtn.data.prize)
                }
                bootbox.alert(rtn.msg);
            }
        })
    });

    $(".book-delete").on('click', function () {
        const bid = $(this).parents("tr").attr('data-bid');
        $.ajax({
            url    : '/book/' + bid,
            method : 'DELETE',
            type   : 'json',
            success: function (rtn) {
                if (rtn.code == '1') {
                    _tr.find("input[name='prize']").val(rtn.data.prize)
                }
                bootbox.alert(rtn.msg);
            }
        })
    });
</script>
<%@ include file="../_footer.jsp" %>
