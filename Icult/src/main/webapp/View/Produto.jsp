<%-- 
    Document   : produto
    Created on : Oct 8, 2017, 10:03:38 AM
    Author     : kalango
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="Cabecalho.jsp" />

<div id="mainBody">
    <div class="container">
        <h1>Meus Produtos</h1>
       <a href="#produto" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success">Novo Produto</span></a>
           <div id="produto" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="produto" aria-hidden="false" >
                     <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                           <h3>Acesso</h3>
                     </div>
                     <div class="modal-body">
                         <h2>Acesse com sua conta</h2>
                           <form action="produto" method="POST" class="form-horizontal loginFrm">
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
                        <input type="submit" value="Cadastrar">
                    </from>		
                <button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
          </div>
         </div>
    <br>
    
    <!--AQUI POR A LISTAGEM DOS PRODUTOS DO USUARIO -->
    </div>
    <br><br>
<c:import url="Rodape.jsp" />