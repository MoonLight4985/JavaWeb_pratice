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
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入您的用户名">
            <small id="emailHelp" class="form-text text-muted">We'll never share your infomation with anyone
                else.</small>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password"
                   placeholder="请输入您的密码">
        </div>

        <div class="form-group">
            <label for="exampleInputCode1">验证码</label>
            <input type="password" class="form-control" id="exampleInputCode1" name="Vercode"
                   placeholder="请输入验证码">
            <br>
            <img id="code" src="/Inspur/code" onclick="changeCode()">
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
<%--        <div class="form-group form-check">--%>
<%--            <input type="checkbox" class="form-check-input" id="saveme">--%>
<%--            <label class="form-check-label" for="saveme">记住我</label>--%>
<%--        </div>--%>
        <br>
        <br>
        <h3>${msg}</h3>
        <%--        <input type="submit">--%>

    </form>
</div>
</body>
<script type="text/javascript">
    //获取cookie，提取用户名和密码
    var cookies = document.cookie;
    //alert(cookies);
    //Username=admin; Password=123456
    var cookielist = cookies.split("; ");
    for (var i = 0; i < cookielist.length; i++) {
        var ck = cookielist[i];
        var cks = ck.split("=");//["username", "admin"]   ["password", "123456"]
        var cookieValue = decodeURI(cks[1]);
        if (cks[0] === "Username") {
            document.getElementById("username").value=cookieValue;
        }
        if (cks[0] === "Password") {
            document.getElementById("password").value=cookieValue;
        }
    }
    function changeCode() {
        var date = new Date();
        document.getElementById("code").src = "/Inspur/code?" + date;
    }
</script>
</html>
