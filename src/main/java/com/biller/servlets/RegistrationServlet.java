package com.biller.servlets;

import com.biller.dao.UserDao;
import com.biller.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;
    @Override
    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("username"), req.getParameter("password"), req.getParameter("email"));
        boolean isRegistered;
        try {
            isRegistered = userDao.registerUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cookie userCookie = new Cookie("username", user.getUsername());
        userCookie.setMaxAge(86_400);
        resp.addCookie(userCookie);
        resp.sendRedirect("home.jsp");
    }
}
