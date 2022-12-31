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
<a href="${pageContext.request.contextPath}/Menu.jsp">
    <svg t="1672466261762" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
         p-id="898"
         width="48" height="48">
        <path d="M579.2256 95.1808l286.72 187.4432A122.88 122.88 0 0 1 921.6 385.536V798.72a122.88 122.88 0 0 1-122.88 122.88H225.28A122.88 122.88 0 0 1 102.4 798.72V385.4848A122.88 122.88 0 0 1 158.0544 282.624l286.72-187.4432a122.88 122.88 0 0 1 134.4512 0zM492.032 156.4672l-5.2736 2.9696-286.72 187.4944a46.08 46.08 0 0 0-20.48 32.768L179.2 385.536V798.72a46.08 46.08 0 0 0 40.2944 45.7216l5.7856 0.3584h573.44a46.08 46.08 0 0 0 45.7216-40.2944l0.3584-5.7856V385.4848a46.08 46.08 0 0 0-16.2304-35.1232l-4.608-3.4304-286.72-187.4944a46.08 46.08 0 0 0-45.2096-2.9696z m202.1376 516.4544a38.4 38.4 0 0 1 0 76.8H329.8304a38.4 38.4 0 1 1 0-76.8h364.3392z"
              fill="#595959" p-id="899"></path>
    </svg>
</a>

<div style="width: 500px; height: 800px; margin: auto;">
    <h3>hello~<%=name%>
    </h3>
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
