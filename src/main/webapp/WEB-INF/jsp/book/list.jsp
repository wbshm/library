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

<div class="container bs-docs-container">
    <br>
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-4">
                <H3>欢迎${username}访问:</H3>
            </div>
            <div class="col-2">
                <button class="btn btn-success buttonAdd">添加图书</button>
            </div>
        </div>
    </div>
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
</div>
<div id="addBook" style="display: none">
    <div class="container">
        <form data-id="addForm">
            <div class="form-group row">
                <label for="inputAuthor">作者</label>
                <input type="text" class="form-control" id="inputAuthor" aria-describedby="emailHelp"
                       placeholder="Enter Username" name="author">
                <small id="emailHelp" class="form-text text-muted">
                </small>
            </div>
            <div class="form-group row">
                <label for="inputBookName">图书名</label>
                <input type="text" class="form-control" id="inputBookName" placeholder="book_name"
                       name="book_name">
            </div>
            <div class="form-group row">
                <label for="inputCover">封面图</label>
                <input type="text" class="form-control" id="inputCover" placeholder="cover"
                       name="cover">
            </div>
            <div class="form-group row">
                <label for="inputPrize">价格</label>
                <input type="text" class="form-control" id="inputPrize" placeholder="prize"
                       name="prize">
            </div>
        </form>
    </div>
</div>
<script>
    $(".book-update").on('click', function () {
        const _tr = $(this).parents("tr");
        $.ajax({
            url: '/book/' + _tr.attr('data-bid'),
            method: 'POST',
            type: 'json',
            data: {prize: _tr.find("input[name='prize']").val()},
            success: function (rtn) {
                if (rtn.code == '1') {
                    _tr.find("input[name='prize']").val(rtn.data.prize)
                }
                bootbox.alert(rtn.msg);
            }
        })
    });

    $(".book-delete").on('click', function () {
        const _this = $(this)
        const bid = $(this).parents("tr").attr('data-bid');

        $.ajax({
            url: '/book/' + bid,
            method: 'DELETE',
            type: 'json',
            success: function (res) {
                if (res.code === 1) {
                    _this.parents("tr").remove();
                }
                bootbox.alert(res.msg);
            }
        })
    });

    $('.buttonAdd').on('click', function () {
        let _html = $('#addBook').html();
        bootbox.confirm({
            title: "Destroy planet?",
            message: _html.replace("data-id", "id"),
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Cancel'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function (result) {
                if (result) {
                    if (!addBook()) {
                        return false;
                    }
                }
            }
        });
    });

    function addBook() {
        $.ajax({
            url: '/book/add',
            type: 'post',
            dataType: "json",
            data: $('#addForm').serialize(),
            // async: false, //取消异步请求
            success: function (res) {
                bootbox.alert(res.msg, function () {
                    history.go(0);
                });
            }
        });
    }
</script>
<%@ include file="../_footer.jsp" %>
