package com.mchiu.midtest.servlet;

import com.mchiu.midtest.model.User;
import com.mchiu.midtest.services.AuthService;
import com.mchiu.midtest.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/user-login")
public class LoginServlet extends HttpServlet {
    private AuthService authService;

    @Override
    public void init() throws ServletException {
        this.authService = new AuthService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        try {
            User user = this.authService.login(email, password);
            if(user != null) {
                request.getSession().setAttribute("auth", user);
                response.sendRedirect("user-list");
            }else {
                request.setAttribute("error", "Incorrect email or password!");
                out.println("User loggedIn failure!");
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Incorrect email or password!");
            out.println("User loggedIn failure!");
        }
    }
}
