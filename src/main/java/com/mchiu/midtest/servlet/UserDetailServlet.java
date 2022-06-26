package com.mchiu.midtest.servlet;

import com.mchiu.midtest.model.User;
import com.mchiu.midtest.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserDetailServlet", value = "/user-detail")
public class UserDetailServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.getUserById(id);
            System.out.println(user);
            request.setAttribute("user", user);

            RequestDispatcher dispatcher = request.getRequestDispatcher("user-detail.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
