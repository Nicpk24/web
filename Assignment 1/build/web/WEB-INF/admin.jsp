<%-- 
    Document   : admin
    Created on : Oct 10, 2020, 12:15:36 AM
    Author     : 835178
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Home Inventory</h1><br>
        <h2>Admin Summary</h2><br>
        Total value for all users: $${totalValue}. Most expensive item is ${itemName} at $${price} owned by ${name}.<br>
        <a href="login?logout">Logout</a>
    </body>
</html>
