<%-- 
    Document   : CadastrarCartao
    Created on : 16/10/2017, 14:47:55
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
            <form action="CadastrarCartaoServlet" method="post">
                <p>Nome Do Dono</p>
                <input type="text" name="nome_do_dono" required>  
                <p>Codigo de Segurança</p>
                <input type="text" name="codigo" required> 
                <p>Data de Expiração</p>
                <input type="text" name="data" required >
                <p>Bandeira do Cartão</p>
                <input type="text" name="bandeira" required >
                <p>Número do Cartão</p>
                <input type="text" name="numero_cartao" required>    
                <br>
                <br>
                <input type="submit" value="Enviar" name="cartao">
            </form>
        </div>
    </body>
</html>

