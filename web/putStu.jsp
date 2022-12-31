<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>修改学生</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div style="width: 500px; height: 800px; margin: auto;">
    <h3>添加学生用户</h3>
    <form action="${pageContext.request.contextPath}/stud?method=update&id=${putStudent.id}" method="post">
        <div class="form-group">
            <label for="InputUsername">学生姓名</label>
            <input type="text" class="form-control" id="InputUsername" name="name" value="${putStudent.name}">
            <small id="emailHelp" class="form-text text-muted">We'll never share your information with anyone
                else.</small>
        </div>
        <div class="form-group">
            <label for="InputSid">学号</label>
            <input type="text" class="form-control" id="InputSid" name="sid" value="${putStudent.sid}">
        </div>
        <div class="form-group">
            <label for="InputAge">年龄</label>
            <input type="text" class="form-control" id="InputAge" name="age" value="${putStudent.age}">
        </div>
        <div class="form-group">
            <label for="exampleFormGrade">年级</label>
            <select multiple class="form-control" id="exampleFormGrade" name="grade">
                <option value="2015" <c:if test="${2015 eq putStudent.grade}">selected</c:if> >2015</option>
                <option value="2016" <c:if test="${2016 eq putStudent.grade}">selected</c:if> >2016</option>
                <option value="2017" <c:if test="${2017 eq putStudent.grade}">selected</c:if> >2017</option>
                <option value="2018" <c:if test="${2018 eq putStudent.grade}">selected</c:if> >2018</option>
                <option value="2019" <c:if test="${2019 eq putStudent.grade}">selected</c:if> >2019</option>
                <option value="2020" <c:if test="${2020 eq putStudent.grade}">selected</c:if> >2020</option>
                <option value="2021" <c:if test="${2021 eq putStudent.grade}">selected</c:if> >2021</option>
                <option value="2022" <c:if test="${2022 eq putStudent.grade}">selected</c:if> >2022</option>
                <option value="2023" <c:if test="${2023 eq putStudent.grade}">selected</c:if> >2023</option>
                <option value="2024" <c:if test="${2024 eq putStudent.grade}">selected</c:if> >2024</option>
                <option value="2025" <c:if test="${2025 eq putStudent.grade}">selected</c:if> >2025</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormSex">性别</label>
            <select multiple class="form-control" id="exampleFormSex" name="sex">
                <option value="男" <c:if test="${'男' eq putStudent.sex}">selected</c:if> >男</option>
                <option value="女" <c:if test="${'女' eq putStudent.sex}">selected</c:if> >女</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">修改</button>
    </form>
</div>
</body>
</html>
