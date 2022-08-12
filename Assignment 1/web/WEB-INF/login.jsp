<%-- 
    Document   : login
    Created on : Oct 10, 2020, 12:16:07 AM
    Author     : 835178
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Home Inventory</h1><br>
        <h2>Login</h2><br>
        <form method="post" action="login">
            User name: <input type="text" name="username" value="${username}"><br>
            Password: <input type="text" name="password" value="${password}"><br>
            <input type="submit"><br>
            <span name="message">${message}</span>
        </form>
    </body>
</html>
