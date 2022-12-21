package org.example.servlets;

import org.example.dao.impl.UsersDAO;
import org.example.model.User;
import org.example.util.AppConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = req.getRequestDispatcher("login.html");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        final String password = req.getParameter("pwd");
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("login.html");

        User user = new UsersDAO().getByEmail(email);
        if (user == null) {
            resp.getWriter().println("user does not exist. Please <a href='registration'> Registration </a>");
            rd.include(req, resp);
        } else if (password.equals(user.getPassword())) {
            rd = req.getRequestDispatcher("welcome");
            rd.forward(req, resp);
        } else {
            resp.getWriter().println("wrong email or password");
            rd.include(req, resp);
        }
    }
}
