package com.biller.servlets;

import com.biller.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    UserDao userDao;
    @Override
    public void init() throws ServletException {
         userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie usernameCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("username")).findFirst().get();
        String username = usernameCookie.getValue();
        int userID = -1;
        try {
            userID = userDao.getUserID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("text/html");
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<title>Biller Home</title>");
        printWriter.println("<link rel=\"stylesheet\" href=\"homeStyle.css\">");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1> User Page</h1>");
        printWriter.println("<div class=\"user-info\">");
        printWriter.println("<h2>" + userID + " " + username + "</h2>");
        printWriter.println("<a href=\"logout\">Log Out</a>");
        printWriter.println("</div>");
        printWriter.println("<div class=\"sessions\">");
        printWriter.println("</div>");
    }
}
