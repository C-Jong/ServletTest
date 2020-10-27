<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/10/26
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="get">
    <input type="hidden" value="<%=request.getParameter("Id")%>" name="Id">
    类别名称<input type="text" name="categoryName"><br><br>
    类别描述<input type="text" name="description"><br><br>
    <input type="submit" value="确定修改">
    <input type="reset" value="重置">
</form>
</body>
</html>
