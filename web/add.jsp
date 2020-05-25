<%--
  Created by IntelliJ IDEA.
  User: 喻杨
  Date: 2020/5/24
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/student" method="post">
        姓名：<input type="text" name="name"/><br/>
        年龄：<input type="text" name="age"/><br/>
        <input type="hidden" name="method" value="add">
        <input type="submit" value="提交">
    </form>

</body>
</html>
