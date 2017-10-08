<%-- 
    Document   : RegisterUsuario
    Created on : 08/10/2017, 08:45:19
    Author     : LucasPC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Icult</title>   
    </head>

    <body>       
        <div id="geral">        
            <form action="RegisterUsuarioServlet" method="post">
                <p>Nome</p>
                <input type="text" name="name" required>  
                <p>CPF</p>
                <input type="text" name="cpf" required> 
                <p>E-mail</p>
                <input type="email" name="email" required >
                <p>Password</p>
                <input type="password" name="psw" required >
                <p>Nick Name</p>
                <input type="text" name="nickname" required>    
                <br>
                <br>
                <input type="submit" value="enviar" name="Enviar">
            </form>
        </div>
    </body>
</html>
