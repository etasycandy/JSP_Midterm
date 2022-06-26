<%@ page import="com.mchiu.midtest.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if(auth == null) {
        response.sendRedirect("user-login");
    }
%>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>User List</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container container-sm">
    <h1 class="text-center my-3">User
        <strong>
            ${user.getFirstName()} ${user.getLastName()}
        </strong>
        Detail</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">FirstName</th>
            <th scope="col">LastName</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">${user.getId()}</th>
            <td>${user.getFirstName()}</td>
            <td>${user.getLastName()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getPassword()}</td>
            <td>
                <a class="btn btn-outline-danger" href="user-form?action=delete&id=${user.getId()}">Delete</a>
                <a class="btn btn-outline-info" href="user-form?action=update&id=${user.getId()}">Update</a>
            </td>

        </tr>
        </tbody>
    </table>
    <a href="user-list" class="btn btn-sm btn-secondary my-5">Back</a>
</div>
</body>
</html>
