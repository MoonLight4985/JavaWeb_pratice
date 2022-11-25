<%@ page import="org.example.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: MoonLight
  Date: 2022/9/21
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>猜数字</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("loginUser");
    String name = user.getName();
%>

    <div style="width: 500px; height: 800px; margin: auto;">
        <h3>hello~<%=name%></h3>
        <form method="get" action="${pageContext.request.contextPath}/guess">
            <div class="form-group">
                <label for="exampleInput">猜一猜</label>
                <input type="text" class="form-control" id="exampleInput" name="number">
            </div>
            <button type="submit" class="btn btn-primary">确定</button>
        </form>
        ${msg}
    </div>

</body>
</html>
