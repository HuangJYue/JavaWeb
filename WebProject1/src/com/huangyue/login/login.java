package com.huangyue.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginIn")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        req.setCharacterEncoding("UTF-8");

        if (name.equals("huang") && password.equals("huang")) {
            resp.sendRedirect("welcome.jsp");
        } else {
            resp.sendRedirect("wrong.jsp");
        }
    }
}
