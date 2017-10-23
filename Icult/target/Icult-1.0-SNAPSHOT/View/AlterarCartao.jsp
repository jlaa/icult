<%-- 
    Document   : AlterarCartao
    Created on : 16/10/2017, 15:49:12
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
            <h1>Lista de Cartões</h1>
            <%for(int i=0;i<(Integer)request.getAttribute("contador");i++){%>
            <p>Cartão de Credito:</p>
            <form action="AlterarCartaoServlet" method="post">
                <p>Nome Do Dono</p>
                <input type="text" name="nome_do_dono" value="<%=request.getAttribute("nome_do_dono"+i)%>" required>  
                <p>Codigo de Segurança</p>
                <input type="text" name="codigo"  value="<%=request.getAttribute("codigo_de_seguranca"+i)%>" required> 
                <p>Data de Expiração</p>
                <input type="text" name="data" value="<%=request.getAttribute("data_de_validade"+i)%>" required >
                <p>Bandeira do Cartão</p>
                <input type="text" name="bandeira" value="<%=request.getAttribute("bandeira"+i)%>" required >
                <p>Número do Cartão</p>
                <input type="text" name="numero_cartao" value="<%=request.getAttribute("numero_cartao"+i)%>" required>    
                <br>
                <br>
                <input type="submit" value="Alterar" name="cartao" >
            </form>
            <%}%>
        </div>
    </body>
</html>


