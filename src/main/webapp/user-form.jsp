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
    <h1 class="text-center my-3">Update user: #<strong>${user.getFirstName()} ${user.getLastName()}</strong></h1>
    <%--@elvariable id="user" type="com.example.loginapp.models.User"--%>
    <form action="user-form" method="POST">

        <input type="text" class="d-none" name="id" value="${user.getId()}">
        <input type="text" class="d-none" name="password" value="${user.getPassword()}">

        <div class="mb-3">
            <label for="firstName" class="form-label">First Name</label>
            <input value="${user.getFirstName()}" type="text" name="firstName" class="form-control" id="firstName" />
        </div>

        <div class="mb-3">
            <label for="lastName" class="form-label">Last Name</label>
            <input value="${user.getLastName()}" type="text" name="lastName" class="form-control" id="lastName" />
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input value="${user.getEmail()}" type="text" name="email" class="form-control" id="email" />
        </div>

        <input type="submit" class="btn w-100 btn-primary" value="Update" />
    </form>

    <a href="user-detail?id=${user.getId()}" class="btn btn-sm btn-secondary my-5">Back</a>
</div>
</body>
</html>
