package com.cjc.HelloServlet;

import com.cjc.JDBCUtils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String categoryName = request.getParameter("categoryName");
        String description = request.getParameter("description");
        String id = request.getParameter("Id");
        try {
            JDBCUtil.Update(categoryName,description,id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        out.println("<h1><a href ='/ServletTest_war_exploded/select.jsp'>返回上一页</a></h1>");
    }
}
