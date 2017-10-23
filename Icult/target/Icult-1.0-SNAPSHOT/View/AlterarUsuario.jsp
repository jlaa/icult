
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.icult.model.Usuario"%>
<%-- 
    Document   : RegisterUsuario
    Created on : 08/10/2017, 08:45:19
    Author     : LucasPC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="Cabecalho.jsp" />
       <div id="mainBody">
	<div class="container">       
            <form action="AlterarUsuarioServlet" method="post">
                <p>Nome</p>
                <input type="text" name="name" value="<%=request.getAttribute("name")%>" required>               
                <p>Nick Name</p>
                <input type="text" name="nickname" value="<%=request.getAttribute("username")%>" required>    
                <br>
                <br>
                <input type="submit" value="Alterar" name="alterar">                
            </form>
            <a href="#cartao" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success">Cadastrar Cartão</span></a>
            <div id="cartao" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="cartao" aria-hidden="false" >
            <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                  <h3>Inserir Cartão</h3>
            </div>
            <div class="modal-body">
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
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
                </form>
            </div>
            </div>
            <br>
            <br>
            <c:if test="${usuarioAtual.getCartaos() != null}">
            <form action="AlterarCartaoServlet" method="post">
                <input type="submit" value="Alterar Cartão" name="cartaoAlterar">
            </form>
            </c:if>
        </div>
       </div>
<c:import url="Rodape.jsp"/>

