<%-- 
    Document   : admin
    Created on : Nov 9, 2020, 10:19:31 PM
    Author     : 835178
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="card">
            <h1>Home Inventory</h1>
            <span>${message}</span>
            <h3>Menu</h3>
            <ul>
                <li><a href="inventory">Inventory</a></li>
                <li><a href="admin">Admin</a></li>
                <li><a href="login?logout">Logout</a></li>
            </ul>
            <h2>Manage Users</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>
                                <form action="admin" method="POST">
                                    <input type="hidden" name="userEmail" value="${user.email}">
                                    <input type="hidden" name="userPassword" value="${user.password}">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="submit" value="Delete">
                                </form>
                            </td>
                            <td>
                                <form action="admin" method="POST">
                                    <input type="hidden" name="userEmail" value="${user.email}">
                                    <input type="hidden" name="userPassword" value="${user.password}">
                                    <input type="hidden" name="action" value="edit">
                                    <input type="submit" value="Edit">
                                </form>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:if test="${userToEdit != null}">
                <h2>Edit User</h2>
                <form action="admin" method="POST">
                    Email:<input type="text" name="editEmail" value="${userToEdit.email}"><br>
                    First Name:<input type="text" name="editFirstName" value="${userToEdit.firstName}"><br>
                    Last Name:<input type="text" name="editLastName" value="${userToEdit.lastName}"><br>
                    Password:<input type="password" name="editPassword" value="${userToEdit.password}"><br>
                    <input type="hidden" name="action" value="saveEdit">
                    <input type="submit" value="Save">
                </form>
            </c:if>


            <h2>Add User</h2>
            <form action="admin" method="POST">
                Email:<input type="text" name="addEmail"><br>
                First Name:<input type="text" name="addFirstName"><br>
                Last Name:<input type="text" name="addLastName"><br>
                Password:<input type="password" name="addPassword"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </div>
    </body>
</html>
