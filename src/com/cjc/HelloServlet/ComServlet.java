package com.cjc.HelloServlet;

import com.cjc.JavaBean.Rectangle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

public class ComServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        area(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void area (HttpServletRequest request, HttpServletResponse response)throws ServerException,IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("gb2312");
        PrintWriter out = response.getWriter();
        String Long = request.getParameter("long");
        String Wide = request.getParameter("wide");
        Rectangle rectangle = new Rectangle(Long,Wide);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<HEAD>");
        out.println("<TITLE>Rectangle Servlet</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY BGCOLOR=white>");
        out.println("<FONT COLOR=BLACK SIZE='5'>");
        out.println("长为"+rectangle.getLong()+"宽为"+rectangle.getWide()+"的矩形面积是："+rectangle.mul());
        out.println("</FONT>");
        out.println("</BODY>");
        out.println("</html>");
        out.flush();

    }
}
