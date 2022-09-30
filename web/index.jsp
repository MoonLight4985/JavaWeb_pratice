<%--
  Created by IntelliJ IDEA.
  User: MoonLight
  Date: 2022/9/21
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div style="width: 500px; height: 800px; margin: auto;">
    <form action="/Inspur/login" method="post">

        <div class="form-group">
            <label for="exampleInputEmail1">用户名</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="username" placeholder="请输入您的用户名">
            <small id="emailHelp" class="form-text text-muted">We'll never share your infomation with anyone
                else.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">密码</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password"
                   placeholder="请输入您的密码">
        </div>

        <div class="form-group">
            <label for="exampleInputCode1">验证码</label>
            <input type="password" class="form-control" id="exampleInputCode1" name="password"
                   placeholder="请输入验证码">
            <br>
            <img id="code" src="/Inspur/code" onclick="changeCode()">
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
        <span color="red">${msg}</span>
        <%--        <input type="submit">--%>

    </form>
</div>
</body>
<script type="text/javascript">
    function changeCode() {
        var date = new Date();
        document.getElementById("code").src = "/Inspur/code?" + date;
    }
</script>
</html>
