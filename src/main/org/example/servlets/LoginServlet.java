package org.example.servlets;

import org.example.util.AppConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter pw = resp.getWriter();
//
//        pw.println("<form action='test'>");
//        pw.println("<label for='email'>Email:</label><br>");
//        pw.println("<input type='email' id='email' name='email' value='John@gmail.com'><br>");
//        pw.println("<label for='pwd'>Last name:</label><br>");
//        pw.println("<input type='password' id='pwd' name='pwd' value=''><br><br>");
//        pw.println("<input type='submit' value='Login'>");
//        pw.println("</form>");

        RequestDispatcher rd = req.getRequestDispatcher("login.html");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        final String password = req.getParameter("pwd");

        if (email.trim().equalsIgnoreCase(AppConstants.DUMMY_USER_EMAIL) && password.equals(AppConstants.DUMMY_USER_PWD)) {
            RequestDispatcher rd = req.getRequestDispatcher("welcome");
            rd.forward(req, resp);
        }  else {
            resp.setContentType("text/html");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            resp.getWriter().println("wrong email or password");
            rd.include(req, resp);
        }
    }
}
