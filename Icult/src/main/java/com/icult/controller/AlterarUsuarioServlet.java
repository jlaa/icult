/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.controller;

import com.icult.model.Aplicacao;
import com.icult.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LucasPC
 */
public class AlterarUsuarioServlet extends HttpServlet {
    @EJB
    private Aplicacao aplicacao;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (request.getParameter("alterar") == null) {
            RequestDispatcher view = request.getRequestDispatcher("View/AlterarUsuario.jsp?faces-redirect=true");
            Usuario usuario =(Usuario)session.getAttribute("usuarioAtual");
            request.setAttribute("username",usuario.getNickName());           
            request.setAttribute("name",usuario.getNome());                    
            view.forward(request, response);
        }else {        
            RequestDispatcher view = request.getRequestDispatcher("View/Logado.jsp?faces-redirect=true");
            String username = request.getParameter("nickname");
            String nome = request.getParameter("name");
            request.setAttribute("cadastro", "ok");
            Usuario usuario = (Usuario) session.getAttribute("usuarioAtual");         
            usuario.setNome(nome);
            usuario.setLogin(username);       
            aplicacao.AlterarUsuario(usuario);
            session.setAttribute("username", username);
            view.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
