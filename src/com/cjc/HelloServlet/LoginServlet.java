package com.cjc.HelloServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.cjc.loginUtil.loginInfo;

public class LoginServlet extends HttpServlet {
    String Mysql_userName,Mysql_password,Mysql_dbURL,Mysql_driverName;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Mysql_driverName = config.getInitParameter("driverName");
        Mysql_dbURL = config.getInitParameter("dbURL");
        Mysql_userName = config.getInitParameter("userName");
        Mysql_password = config.getInitParameter("password");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        boolean message;
        loginInfo loginInfo = new loginInfo(Mysql_driverName,Mysql_dbURL,Mysql_userName,Mysql_password);
        try {
            message = loginInfo.message(request.getParameter("userName"),request.getParameter("password"));
            if (message){
                RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");
                if (dispatcher != null) dispatcher.forward(request,response);
            }else {
                out.println("<h1 style='color:red'>你输入的用户名或密码不正确！</h1>");
                out.println("<a href ='/ServletTest_war_exploded/Login.jsp'>返回上一页</a>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
