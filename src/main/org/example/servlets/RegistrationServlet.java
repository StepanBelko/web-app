package org.example.servlets;

import org.example.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = req.getRequestDispatcher("registration.html");
        rd.forward(req, resp);
        User user = new User();

        if (req.getParameter("pwd1") == req.getParameter("pwd") && req.getParameter("email") != null) {
            user.setName(req.getParameter("email"));
            user.setPassword(req.getParameter("pwd1"));
            req.getRequestDispatcher("login.html").forward(req, resp);
        }

        System.out.println("new user added");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
