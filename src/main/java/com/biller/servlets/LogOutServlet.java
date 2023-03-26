package com.biller.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie emptyUsernameCookie = new Cookie("username", "");
        emptyUsernameCookie.setMaxAge(0);
        resp.addCookie(emptyUsernameCookie);
        resp.sendRedirect("index.jsp");
    }
}
