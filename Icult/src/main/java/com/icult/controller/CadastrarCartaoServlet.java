/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.controller;

import com.icult.model.Aplicacao;
import com.icult.model.CartaoDeCredito;
import com.icult.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

/**
 *
 * @author LucasPC
 */
public class CadastrarCartaoServlet extends HttpServlet {

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
        if (request.getParameter("cartao") == null) {
            RequestDispatcher view = request.getRequestDispatcher("View/CadastrarCartao.jsp?faces-redirect=true");
            view.forward(request, response);
        } else {

            RequestDispatcher view = request.getRequestDispatcher("View/Logado.jsp?faces-redirect=true");
            String nome_do_dono = request.getParameter("nome_do_dono");
            String codigo = request.getParameter("codigo");
            int codigo_de_seguranca = Integer.parseInt(codigo);
            String data = request.getParameter("data");
            Calendar data_de_validade = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                data_de_validade = Calendar.getInstance();
                data_de_validade.setTime(sdf.parse(data));
            } catch (ParseException e) {

            }
            String bandeira = request.getParameter("bandeira");
            String numero_cartao = request.getParameter("numero_cartao");
            request.setAttribute("cadastro", "ok");
            CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
            cartaoDeCredito.cadastrarCartao(nome_do_dono, codigo_de_seguranca,
                    data_de_validade, bandeira, numero_cartao);
            HttpSession session = request.getSession(false);
            Usuario usuario = (Usuario) session.getAttribute("usuarioAtual");            
            cartaoDeCredito.setUsuario(usuario);
            List<CartaoDeCredito> cartaos = usuario.getCartaos();
            cartaos.add(cartaoDeCredito);
            usuario.setCartaos(cartaos);
            aplicacao.AlterarUsuario(usuario);
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
