package com.mchiu.midtest.servlet;

import com.mchiu.midtest.model.User;
import com.mchiu.midtest.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserFormServlet", value = "/user-form")
public class UserFormServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("delete") ) {
            try {
                this.deleteUser(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                User user = userService.getUserById(id);

                request.setAttribute("user", user);

                RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        User user = new User(id, firstName, lastName, email, password);

        try {
            userService.updateUser(user);

            response.sendRedirect("user-list");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("user-list");
//            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            this.userService.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("user-list");
    }

}
