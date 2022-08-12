<%-- 
    Document   : inventory
    Created on : Nov 9, 2020, 10:19:46 PM
    Author     : 835178
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="card">
            <h1>Home Inventory</h1>
            <h3>Menu</h3>
            <ul>
                <li><a href="inventory">Inventory</a></li>
                <li><a href="admin">Admin</a></li>
                <li><a href="login?logout">Logout</a></li>
            </ul>
            <h2>Inventory for ${user.firstName} ${user.lastName}</h2>
            <span name="message">${message}</span>
            <table border="1">
                <thead>
                    <tr>
                        <th>Category</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${items}">
                    <form action="inventory?action=delete" method="POST">
                        <tr>
                            <td>${item.category.categoryName}</td>
                            <td>${item.itemName}</td>
                            <td>\$${item.price}</td>
                            <td><input type="submit" value="Delete"></td>
                        <input type="hidden" name="item" value="${item.itemId}">
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <h2>Add Item</h2>
            <form action="inventory?action=add" method="POST">
                Category:<select name="addItemCategory">
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.categoryId}">${category.categoryName}</option>
                    </c:forEach>
                </select><br>
                Name:<input type="text" name="addItemName"><br>
                Price:<input type="text" name="addItemPrice"><br>
                <input type="submit" value="Save">
            </form>
        </div>
    </body>
</html>