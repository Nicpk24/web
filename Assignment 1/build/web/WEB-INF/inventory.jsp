<%-- 
    Document   : inventory
    Created on : Oct 10, 2020, 12:26:15 AM
    Author     : 835178
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Page</title>
    </head>
    <body>
        <h1>Home Inventory for ${username}</h1><br>
        <h2>Add Item</h2><br>
        <form method="post" action="inventory">
            Category:
            <select name="category">
                <option value="bedroom">Bedroom</option>
                <option value="garage">Garage</option>
                <option value="kitchen">Kitchen</option>
                <option value="livingRoom">Living room</option>
            </select><br>
            Item name: <input type="text" name="itemName" value="${itemName}"><br>
            Price: <input type="text" name="price" value="${price}"><br>
            <input type="submit" value="Add"><span name="errorMessage">${errorMessage}</span><br>
            <span name="message">Total value in inventory: $${message}.</span><br>
            <a href="login?logout" >Logout</a>
        </form>
        
    </body>
</html>
