<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<div style="background-color: pink;width:500px;margin:0 auto;text-align: center" >
    <form action="loginServlet" method="get">
        请输入用户名：<input type="text" name="userName"><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;请输入密码：<input type="password" name="password"><br><br>
        <input type="submit" value="登陆">&nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
