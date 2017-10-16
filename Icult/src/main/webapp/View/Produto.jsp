<%-- 
    Document   : produto
    Created on : Oct 8, 2017, 10:03:38 AM
    Author     : kalango
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produto</h1>
        <br>
    <from action="produto" method="POST">
        <label>Nome: </label>
        <input type="text" name="name" required>
        <br>
        
        <label>Quantidade: </label>
        <input type="number" name="qtt" required>
        <br>
        
        <label>Valor: </label>
        <input type="text" name="value" required>
        <br>
        
        <label>Caracteristicas: </label>
        <textarea name="characteristics" rows="4" cols="50"></textarea>
        <br>
        
        <input type="hidden" value="user" value="">
    </from>
    </body>
</html>