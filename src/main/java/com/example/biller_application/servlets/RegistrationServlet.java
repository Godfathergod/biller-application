package com.example.biller_application.servlets;

import com.example.biller_application.dao.UserDao;
import com.example.biller_application.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
    }
}
