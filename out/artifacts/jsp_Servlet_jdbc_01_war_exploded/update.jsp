<%--
  Created by IntelliJ IDEA.
  User: 喻杨
  Date: 2020/5/25
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/student" method="post">
        编号：<input type="text" name="id" value="${student.id}" readonly/><br/>
        姓名：<input type="text" name="name" value="${student.name}"/><br/>
        年龄：<input type="text" name="age" value="${student.age}"}>
        <input type="hidden" name="method" value="update">
        <input type="submit" value="修改">
    </form>

</body>
</html>
