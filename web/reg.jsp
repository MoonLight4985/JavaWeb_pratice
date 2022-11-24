<%--
  Created by IntelliJ IDEA.
  User: MoonLight
  Date: 2022/11/18
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div style="width: 500px; height: 800px; margin: auto;">
    <h3>用户注册</h3>
    <form>
        <div class="form-group">
            <label for="InputUsername">用户名</label>
            <input type="text" class="form-control" id="InputUsername">
            <small id="emailHelp" class="form-text text-muted">We'll never share your information with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="InputPassword">密码</label>
            <input type="password" class="form-control" id="InputPassword">
        </div>
        <div class="form-group">
            <label for="exampleInputAge">年龄</label>
            <input type="password" class="form-control" id="exampleInputAge">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
