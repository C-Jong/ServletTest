<%@ page import="com.cjc.JavaBean.Categories" %>
<%@ page import="com.cjc.JDBCUtils.JDBCUtil" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/10/26
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="position: relative">
    <table cellpadding="5px" cellspacing="0px" border="3px" style="margin: auto">
        <tr>
            <th>类别编号</th>
            <th>类别名称</th>
            <th>类别描述</th>
            <th>删除</th>
            <th>更新</th>
        </tr>

        <%
            ArrayList<Categories> retrieve = JDBCUtil.Retrieve();
            for (Categories categories : retrieve){
        %>
        <tr>
            <td><%=categories.getCategoryID()%></td>
            <td><%=categories.getCategoryName()%></td>
            <td><%=categories.getDescription()%></td>
            <td><a href="delete?Id=<%=categories.getCategoryID()%>" >删除</a></td>
            <td><a href="update.jsp?Id=<%=categories.getCategoryID()%>">更新</a></td>
            <%}%>
        </tr>
    </table>

    <div style="position: absolute;margin-top: -270px; margin-left: 360px">
        <h2>增加产品种类</h2>
        <form action="create" method="get">
            类别名称 <input type="text" name="categoryName"><br><br>
            类别描述 <input type="text" name="description"><br><br>
            <input type="submit" value="确定增加">
            <input type="reset" value="重置">
        </form>
    </div>
</div>
</body>
</html>
