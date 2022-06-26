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

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="d-flex align-items-center w-100 container">
        <a class="navbar-brand"  href="#">HOM PAGE</a>
        <div class="w-100 d-flex justify-content-between">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active">Add an Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" >List Employee</a>
                </li>
            </ul>
            <div>
                <a class="btn btn-sm btn-outline-primary text-white">
                    ${auth.getEmail()}
                </a>
                <a class="btn btn-sm btn-outline-danger text-white" href="user-logout" >Logout></a>
            </div>
        </div>
    </div>
</nav>

<div class="container container-sm">


    <h1 class="text-center my-3">Welcome to Employee Management System</h1>
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
        <c:forEach var="user" items="${users}">
            <tr>
                <th scope="row"> <c:out value = "${user.getId()}"/> </th>
                <td> <c:out value = "${user.getFirstName()}"/></td>
                <td> <c:out value = "${user.getLastName()}"/> </td>
                <td><c:out value = "${user.getEmail()}"/></td>
                <td>****************</td>
                <td>
                    <a class="btn btn-primary" href="user-detail?id=${user.getId()}">Show user</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
