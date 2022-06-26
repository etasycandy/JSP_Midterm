<%@ page import="com.mchiu.midtest.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if(auth != null) {
        response.sendRedirect("user-list");
    }
%>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container container-sm">
    <h1 class="text-center my-3">Register</h1>

    <form action="user-register" method="POST" >
        <div class="mb-3">
            <label class="form-label">First Name</label>
            <input type="text " class="form-control" name="firstName" />
        </div>

        <div class="mb-3">
            <label class="form-label">Last Name</label>
            <input type="text " class="form-control" name="lastName" />
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email " class="form-control" name="email" />
        </div>

        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password " name="password" class="form-control" />
        </div>

        <input type="submit" class="btn w-100 btn-primary" value="Register" />
    </form>

    <p  class="text-center my-4">Navigate login page <a class="my-3 btn btn-sm btn-outline-info" href="user-login">Login</a></p>

</div>
</body>
</html>
