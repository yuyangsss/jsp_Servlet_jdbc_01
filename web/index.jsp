<%--
  Created by IntelliJ IDEA.
  User: 喻杨
  Date: 2020/5/6
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>学生管理系统</h1>
  <table>
      <tr>
          <th>编号</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>生日</th>
          <th>操作</th>
      </tr>
      <c:forEach items="${list}" var="student">
          <tr>
          <td>${student.id}</td>
          <td>${student.name}</td>
          <td>${student.age}</td>
              <td>${student.date}</td>
              <td>
                  <a href="/student?method=delete&id=${student.id}">删除</a>
                  <a href="/student?method=findByid&id=${student.id}">修改</a>
              </td>
          </tr>
      </c:forEach>

  </table>
  </body>
</html>
