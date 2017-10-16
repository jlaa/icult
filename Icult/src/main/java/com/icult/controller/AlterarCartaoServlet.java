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
public class AlterarCartaoServlet extends HttpServlet {

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
        Usuario usuario = (Usuario) session.getAttribute("usuarioAtual");
        if (request.getParameter("cartao") == null) {
            RequestDispatcher view = request.getRequestDispatcher("View/AlterarCartao.jsp?faces-redirect=true");
            
            List<CartaoDeCredito> cartaos = usuario.getCartaos();
            for (int i = 0; i < cartaos.size(); i++) {
                request.setAttribute("nome_do_dono" + i, cartaos.get(i).getNome_do_dono());
                request.setAttribute("codigo_de_seguranca" + i, cartaos.get(i).getCodigo_de_seguranca());
                Calendar cal = cartaos.get(i).getData_de_validade();
                cal.add(Calendar.DATE, 1);
                SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
                String dataString = format1.format(cal.getTime());
                request.setAttribute("data_de_validade" + i, dataString);
                request.setAttribute("bandeira" + i, cartaos.get(i).getBandeira());
                request.setAttribute("numero_cartao" + i, cartaos.get(i).getNumero_cartao());
            }
            request.setAttribute("contador", cartaos.size());
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("AlterarUsuarioServlet");
            String nome_do_dono = request.getParameter("nome_do_dono");
            String codigo = request.getParameter("codigo");
            int codigo_de_seguranca = Integer.parseInt(codigo);
            String data = request.getParameter("data");
            Calendar data_de_validade = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                data_de_validade = Calendar.getInstance();
                data_de_validade.setTime(sdf.parse(data));
            } catch (ParseException e) {

            }
            String bandeira = request.getParameter("bandeira");
            String numero_cartao = request.getParameter("numero_cartao");
            CartaoDeCredito cartaoDeCredito = aplicacao.
                    PesquisaCartao((String) request.getParameter("numero_cartao"));      
            cartaoDeCredito.setBandeira(bandeira);
            cartaoDeCredito.setCodigo_de_seguranca(codigo_de_seguranca);
            cartaoDeCredito.setData_de_validade(data_de_validade);
            cartaoDeCredito.setNome_do_dono(nome_do_dono);
            cartaoDeCredito.setNumero_cartao(numero_cartao);
            aplicacao.AlterarCartao(cartaoDeCredito);           
       
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
