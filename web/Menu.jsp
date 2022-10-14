<%@ page import="org.example.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: MoonLight
  Date: 2022/10/7
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <title>登录菜单</title>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("loginUser");
    String name = user.getUsername();
%>
<div class="jumbotron">
    <h1 class="display-4">Hello,<%=name%></h1>
    <p class="lead">本页面为课程练习项目菜单页面，请选择要测试的功能^-^</p>
    <hr class="my-4">
    <p>This page is the menu page of the course practice items, please select the function you want to test^-^</p>
    <a class="btn btn-primary btn-lg" href="/Inspur/Game.jsp" role="button">1. 猜数字小游戏</a>
</div>
</body>
</html>
