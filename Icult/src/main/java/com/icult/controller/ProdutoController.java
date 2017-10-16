/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.controller;

import com.icult.model.Aplicacao;
import com.icult.model.Produto;
import com.icult.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kalango
 */
@WebServlet(name = "produto", urlPatterns = {"/produto"})
public class ProdutoController extends HttpServlet {


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
        
         HttpSession session = request.getSession();
         
        Usuario usuarioId = (Usuario) session.getAttribute("usuarioAtual");
        //int id = (int) usuarioId.getId_usuario();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("produto.jsp?faces-redirect=true");
        dispatcher.forward(request, response);
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
         
        String name = request.getParameter("name");
        String characteristics = request.getParameter("characteristics");
        Double value = Double.parseDouble(request.getParameter("value"));
        int quantity = Integer.parseInt(request.getParameter("qtt"));
        Long user = Long.parseLong(request.getParameter("user"));
        
        Produto newProduct = new Produto(name, Calendar.getInstance(), characteristics, value, quantity);
        
        Aplicacao aplicacao = new Aplicacao();
        aplicacao.cadastrarProduto(newProduct);
        
        
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