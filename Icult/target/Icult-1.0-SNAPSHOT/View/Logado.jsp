<%-- 
    Document   : Logado
    Created on : 08/10/2017, 10:21:43
    Author     : LucasPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ICult</h1>
        <p>Usuario logado:<a href="AlterarUsuarioServlet">${sessionScope.username}</a></p>
        <a href="LogoutServlet">Sair</a>
        
    </body>
</html>
