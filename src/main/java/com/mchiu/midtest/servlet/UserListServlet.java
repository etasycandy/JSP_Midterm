package com.mchiu.midtest.servlet;

import com.mchiu.midtest.model.User;
import com.mchiu.midtest.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserListServlet", value = "/user-list")
public class UserListServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> list = this.userService.getUsers();

            request.setAttribute("users", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");

            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
