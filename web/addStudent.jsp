<%--
  Created by IntelliJ IDEA.
  User: MoonLight
  Date: 2022/11/25
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div style="width: 500px; height: 800px; margin: auto;">
    <h3>添加学生用户</h3>
    <form action="${pageContext.request.contextPath}/student" method="post">
        <div class="form-group">
            <label for="InputUsername">学生姓名</label>
            <input type="text" class="form-control" id="InputUsername" name="name">
            <small id="emailHelp" class="form-text text-muted">We'll never share your information with anyone
                else.</small>
        </div>
        <div class="form-group">
            <label for="InputSid">学号</label>
            <input type="text" class="form-control" id="InputSid" name="sid">
        </div>
        <div class="form-group">
            <label for="InputAge">年龄</label>
            <input type="text" class="form-control" id="InputAge" name="age">
        </div>
        <div class="form-group">
            <label for="exampleFormGrade">年级</label>
            <select multiple class="form-control" id="exampleFormGrade" name="grade">
                <option>2015</option>
                <option>2016</option>
                <option>2017</option>
                <option>2018</option>
                <option>2019</option>
                <option>2020</option>
                <option>2021</option>
                <option>2022</option>
                <option>2023</option>
                <option>2024</option>
                <option>2025</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormSex">性别</label>
            <select multiple class="form-control" id="exampleFormSex" name="sex">
                <option>男</option>
                <option>女</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">添加</button>
    </form>
</div>
</body>
</html>
