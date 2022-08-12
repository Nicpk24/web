<%-- 
    Document   : login
    Created on : Nov 9, 2020, 10:19:54 PM
    Author     : 835178
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="card">
            <h1>Home Inventory</h1>
            <h2>Login</h2>
            <span name="info">${info}</span>
            <form action="login" method="post">
                Email: <input type="text" name="email" value="${email}"><br>
                Password: <input type="password" name="password" value="password"><br>
                <input type="submit" value="Log in">
            </form>
        </div>
    </body>
</html>
