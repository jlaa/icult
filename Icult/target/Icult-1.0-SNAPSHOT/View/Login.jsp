<%-- 
    Document   : Login
    Created on : 08/10/2017, 10:06:49
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

        <div class="container-fluid">
            <div class="row">              
                <div class="col-sm-4 col-md-4 col-lg-4">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h1>Acesse</h1>
                        </div>
                        <div class="panel-body">                            
                            <form action="LoginUsuarioServlet" method="POST">
                                Email: <input type="email" name="email" required><br><br>
                                Senha: <input type="password" name="psw" required><br><br>
                                <button type="submit">Logar</button><br>
                            </form>
                        </div>
                    </div>
                </div>           
            </div>
        </div>
    </body>
</html>

